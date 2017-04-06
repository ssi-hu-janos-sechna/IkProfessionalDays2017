package com.surveysampling.apigateway;

import com.surveysampling.apigateway.feign.*;
import com.surveysampling.apigateway.feign.models.ActionType;
import com.surveysampling.apigateway.feign.models.Depot;
import com.surveysampling.apigateway.feign.models.Product;
import com.surveysampling.apigateway.feign.models.StorageEntry;
import com.surveysampling.apigateway.model.DepotTransaction;
import com.surveysampling.apigateway.model.ProductEntry;
import com.surveysampling.apigateway.model.StoreProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by janos_sechna on 4/3/17.
 */
@RestController
public class GatewayController {

    private DepotFeignClient depotFeignClient;

    private OrderFeignClient orderFeignClient;

    private ProductFeignClient productFeignClient;

    private StorageFeignClient storageFeignClient;

    private UserFeignClient userFeignClient;

    @Autowired
    public GatewayController(DepotFeignClient depotFeignClient, OrderFeignClient orderFeignClient, ProductFeignClient productFeignClient, StorageFeignClient storageFeignClient, UserFeignClient userFeignClient) {
        this.depotFeignClient = depotFeignClient;
        this.orderFeignClient = orderFeignClient;
        this.productFeignClient = productFeignClient;
        this.storageFeignClient = storageFeignClient;
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productFeignClient.getProducts();
    }

    @GetMapping("/products/category/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return productFeignClient.getProductsByCategoryId(categoryId);
    }

    @PostMapping("/storeProducts")
    public void storeProducts(@RequestBody @Valid StoreProductsRequest storeProductsRequest) {

        Depot depot;

        if ((depot = depotFeignClient.getDepotById(storeProductsRequest.getDepotId())) == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Depot with id not exist:" + storeProductsRequest.getDepotId());
        }

        int numberOfItems = storeProductsRequest.getProduct().stream()
                .mapToInt(ProductEntry::getQuantity)
                .sum();

        if (numberOfItems > (depot.getMaximumStorageUnit() - depot.getCurrentStoredUnit())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Can't store in depot with id and name:" + storeProductsRequest.getDepotId() + ":" + depot.getName());
        }

        if (!productFeignClient.isProductsExist(
                storeProductsRequest.getProduct().stream()
                        .map(ProductEntry::getProductId)
                        .collect(Collectors.toList()))) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Some/all of the products not exist.");
        }

        storageFeignClient.addStorageEntries(
                storeProductsRequest.getProduct().stream()
                        .map(productEntry ->
                                new StorageEntry(ActionType.PUT,
                                        productEntry.getProductId(),
                                        depot.getId(),
                                        storeProductsRequest.getUserId(),
                                        productEntry.getQuantity()))
                        .collect(Collectors.toList()));
    }


    @GetMapping("transactions/depot/{depotId}")
    public List<DepotTransaction> getTransactionsForDepot(@PathVariable("depotId") Long depotId) {
        return storageFeignClient.getAllStorageEntryForDepotById(depotId).stream()
                .map(storageEntry -> new DepotTransaction(
                        productFeignClient.getProductById(storageEntry.getProductId()).getName(),
                        storageEntry.getActionType(),
                        storageEntry.getQuantity()))
                .collect(Collectors.toList());
    }
}