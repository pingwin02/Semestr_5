package aui.lab.product.controller;

import lombok.extern.java.Log;
import aui.lab.product.dto.ProductRequestDTO;
import aui.lab.product.dto.ProductResponseDTO;
import aui.lab.product.dto.ProductsResponseDTO;
import aui.lab.product.entity.Product;
import aui.lab.product.function.ProductToResponse;
import aui.lab.product.function.ProductsToResponse;
import aui.lab.product.function.RequestToProduct;
import aui.lab.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.logging.Level;

@RestController
@Log
public class ProductController {

    private final ProductService service;

    private final ProductToResponse productToResponse;

    private final ProductsToResponse productsToResponse;

    private final RequestToProduct requestToProduct;

    @Autowired
    public ProductController(ProductService service,
                             ProductToResponse productToResponse,
                             ProductsToResponse productsToResponse,
                             RequestToProduct requestToProduct) {
        this.service = service;
        this.productToResponse = productToResponse;
        this.productsToResponse = productsToResponse;
        this.requestToProduct = requestToProduct;
    }

    @GetMapping("/api/products")
    @ResponseStatus(HttpStatus.OK)
    public ProductsResponseDTO getProducts() {
        log.log(Level.INFO, "getProducts");
        return productsToResponse.apply(service.findAll());
    }

    @GetMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO getProductById(@PathVariable UUID id) {
        return service.find(id)
                .map(productToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/warehouses/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public ProductsResponseDTO getProductsByWarehouse(@PathVariable UUID id) {
        return service.findAllByWarehouse(id)
                .map(productsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = requestToProduct.apply(productRequestDTO);
        try {
            service.create(product);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable UUID id, @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = requestToProduct.apply(productRequestDTO);
        service.find(id).ifPresentOrElse(
                (Product productToUpdate) -> {
                    productToUpdate.setName(product.getName());
                    productToUpdate.setWeight(product.getWeight());
                    productToUpdate.setWarehouse(product.getWarehouse());
                    try {
                        service.create(productToUpdate);
                    } catch (Exception e) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable UUID id) {
        service.delete(id);
    }

}
