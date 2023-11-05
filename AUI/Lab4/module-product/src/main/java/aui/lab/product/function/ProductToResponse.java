package aui.lab.product.function;

import aui.lab.product.entity.Product;
import aui.lab.product.dto.ProductResponseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductToResponse implements Function<Product, ProductResponseDTO> {

    @Override
    public ProductResponseDTO apply(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .weight(product.getWeight())
                .warehouseId(product.getWarehouse().getId())
                .build();
    }

}
