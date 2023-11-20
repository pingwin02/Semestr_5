package aui.lab.product.dto;

import lombok.*;

import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponseDTO {

    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDTO {
        private UUID id;

        private String name;

        private int weight;

        private UUID warehouseId;
    }

    private Collection<ProductDTO> products;
}
