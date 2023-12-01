package aui.lab.product.function;

import aui.lab.product.entity.Product;
import aui.lab.product.dto.ProductsResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductsToResponse implements Function<Collection<Product>, ProductsResponseDTO> {

    @Override
    public ProductsResponseDTO apply(Collection<Product> products) {
        return ProductsResponseDTO.builder()
                .products(products.stream()
                        .map(product -> ProductsResponseDTO.ProductDTO.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .weight(product.getWeight())
                                .warehouseId(product.getWarehouse().getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
