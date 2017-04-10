package com.surveysampling.apigateway.validator;

import com.surveysampling.apigateway.feign.*;
import com.surveysampling.apigateway.feign.models.Depot;
import com.surveysampling.apigateway.model.OrderRequest;
import com.surveysampling.apigateway.model.ProductEntry;
import com.surveysampling.apigateway.model.StoreProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Collectors;

/**
 * Created by janos_sechna on 4/9/17.
 */
@Service
public class Validator {

    private DepotFeignClient depotFeignClient;

    private OrderFeignClient orderFeignClient;

    private ProductFeignClient productFeignClient;

    private StorageFeignClient storageFeignClient;

    private UserFeignClient userFeignClient;

    @Autowired
    public Validator(DepotFeignClient depotFeignClient, OrderFeignClient orderFeignClient, ProductFeignClient productFeignClient, StorageFeignClient storageFeignClient, UserFeignClient userFeignClient) {
        this.depotFeignClient = depotFeignClient;
        this.orderFeignClient = orderFeignClient;
        this.productFeignClient = productFeignClient;
        this.storageFeignClient = storageFeignClient;
        this.userFeignClient = userFeignClient;
    }

    public void validateStoreProductRequest(StoreProductsRequest storeProductsRequest) {
        Depot depot;

        if (userFeignClient.getUserById(storeProductsRequest.getUserId()) == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User with id not exist:" + storeProductsRequest.getUserId());
        }

        if ((depot = depotFeignClient.getDepotById(storeProductsRequest.getDepotId())) == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Depot with id not exist:" + storeProductsRequest.getDepotId());
        }

        long numberOfItems = storeProductsRequest.getProduct().stream()
                .mapToLong(ProductEntry::getQuantity)
                .sum();

        if (numberOfItems > (depot.getMaximumStorageUnit() - depot.getCurrentStoredUnit())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Can't store in depot with id and name:" + storeProductsRequest.getDepotId() + ":" + depot.getName());
        }

        if (!productFeignClient.isProductsExist(storeProductsRequest.getProduct().stream()
                .map(ProductEntry::getProductId)
                .collect(Collectors.toList()))) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Some/all of the products not exist.");
        }
    }

    public void validateGetStockForDepot(Long depotId) {
        if (depotFeignClient.getDepotById(depotId) == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Depot with id not exist:" + depotId);
        }
    }

    public void validateGetStockForProduct(Long productId) {
        if (!productFeignClient.isProductExist(productId)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product with id not exist: " + productId);
        }
    }

    public void validatePlaceOrder(OrderRequest orderRequest) {

        if (userFeignClient.getUserById(orderRequest.getUserId()) == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User with id not exist:" + orderRequest.getUserId());
        }

        if (!productFeignClient.isProductsExist(orderRequest.getProducts().stream()
                .map(ProductEntry::getProductId)
                .collect(Collectors.toList()))) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Some/all of the products not exist.");
        }
    }
}