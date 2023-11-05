package aui.lab.product.function;

import aui.lab.product.entity.Product;
import aui.lab.product.dto.ProductRequestDTO;
import aui.lab.warehouse.entity.Warehouse;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToProduct implements Function<ProductRequestDTO, Product> {

    @Override
    public Product apply(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .id(UUID.randomUUID())
                .name(productRequestDTO.getName())
                .weight(productRequestDTO.getWeight())
                .warehouse(Warehouse
                        .builder()
                        .id(productRequestDTO
                                .getWarehouseId())
                        .build())
                .build();
    }

}
