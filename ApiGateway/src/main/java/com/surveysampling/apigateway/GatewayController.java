package com.surveysampling.apigateway;

import com.surveysampling.apigateway.feign.*;
import com.surveysampling.apigateway.feign.models.ActionType;
import com.surveysampling.apigateway.feign.models.Depot;
import com.surveysampling.apigateway.feign.models.Product;
import com.surveysampling.apigateway.feign.models.StorageEntry;
import com.surveysampling.apigateway.model.*;
import com.surveysampling.apigateway.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
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

    private Validator validator;

    @Autowired
    public GatewayController(DepotFeignClient depotFeignClient, OrderFeignClient orderFeignClient, ProductFeignClient productFeignClient, StorageFeignClient storageFeignClient, UserFeignClient userFeignClient, Validator validator) {
        this.depotFeignClient = depotFeignClient;
        this.orderFeignClient = orderFeignClient;
        this.productFeignClient = productFeignClient;
        this.storageFeignClient = storageFeignClient;
        this.userFeignClient = userFeignClient;
        this.validator = validator;
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
    public void storeProducts(@RequestBody @NotNull @Valid StoreProductsRequest storeProductsRequest) {

        validator.validateStoreProductRequest(storeProductsRequest);

        storageFeignClient.addStorageEntries(
                storeProductsRequest.getProduct().stream()
                        .map(productEntry ->
                                new StorageEntry(ActionType.PUT,
                                        productEntry.getProductId(),
                                        storeProductsRequest.getDepotId(),
                                        storeProductsRequest.getUserId(),
                                        productEntry.getQuantity()))
                        .collect(Collectors.toList()));
    }


    @GetMapping("/transactions/depot/{depotId}")
    public List<DepotTransaction> getTransactionsForDepot(@PathVariable("depotId") Long depotId) {
        return storageFeignClient.getAllStorageEntryForDepotById(depotId).stream()
                .map(storageEntry -> new DepotTransaction(
                        productFeignClient.getProductById(storageEntry.getProductId()).getName(),
                        storageEntry.getActionType(),
                        storageEntry.getQuantity()))
                .collect(Collectors.toList());
    }

    @GetMapping("/stock/product/{productId}")
    public GetStockForProductResponse getStockForProduct(@PathVariable("productId") Long productId) {
        validator.validateGetStockForProduct(productId);

        GetStockForProductResponse getStockForProductResponse = new GetStockForProductResponse();
        getStockForProductResponse.setProduct(productFeignClient.getProductById(productId));

        List<StorageEntry> storageEntries = storageFeignClient.getAllStorageEntryForProductById(productId);
        Map<Long, Depot> depots = depotFeignClient.getDepots().stream().collect(Collectors.toMap(Depot::getId, o -> o));

        getStockForProductResponse.setProductList(storageEntries.stream()
                .collect(Collectors.groupingBy(StorageEntry::getDepotId)).entrySet().stream()
                .map(longListEntry -> {
                    ProductStock productStock = new ProductStock();
                    productStock.setDepot(depots.get(longListEntry.getKey()));
                    productStock.setQuantity(longListEntry.getValue().stream()
                            .mapToLong(storageEntry -> storageEntry.getActionType() == ActionType.WITHDRAW ? storageEntry.getQuantity() * -1 : storageEntry.getQuantity())
                            .sum());
                    return productStock;
                }).collect(Collectors.toList()));
        return getStockForProductResponse;
    }

    @GetMapping("/stock/depot/{depotId}")
    public GetStockForDepotResponse getStockForDepot(@PathVariable("depotId") Long depotId) {
        validator.validateGetStockForDepot(depotId);

        GetStockForDepotResponse getStockForDepotResponse = new GetStockForDepotResponse();
        getStockForDepotResponse.setDepot(depotFeignClient.getDepotById(depotId));
        getStockForDepotResponse.setProductList(storageFeignClient.getAllStorageEntryForDepotById(depotId).stream()
                .collect(Collectors.groupingBy(StorageEntry::getProductId)).entrySet().stream()
                .map(longListEntry -> {
                    ProductEntry productEntry = new ProductEntry();
                    productEntry.setProductId(longListEntry.getKey());
                    productEntry.setQuantity(longListEntry.getValue().stream()
                            .mapToLong(storageEntry -> storageEntry.getActionType() == ActionType.WITHDRAW ? storageEntry.getQuantity() * -1 : storageEntry.getQuantity())
                            .sum());
                    return productEntry;
                }).collect(Collectors.toList()));
        return getStockForDepotResponse;
    }

    @PostMapping("placeOrder")
    public OrderEntry placeOrder(@RequestBody @NotNull @Valid OrderRequest orderRequest) {
        validator.validatePlaceOrder(orderRequest);

        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setProducts(orderRequest.getProducts().stream().map(OrderedProducts::new).collect(Collectors.toList()));
        orderEntry.setUserId(orderRequest.getUserId());
        orderEntry.setStatus(OrderStatus.PENDING);
        return orderFeignClient.saveOrder(orderEntry);
    }

    @GetMapping("orders")
    public List<OrderEntry> getOrders() {
        return orderFeignClient.getOrders();
    }

    @GetMapping("orders/{orderId}")
    public OrderEntry getOrderEntry(@PathVariable("orderId") Long orderId) {
        return orderFeignClient.getOrderById(orderId);
    }

}