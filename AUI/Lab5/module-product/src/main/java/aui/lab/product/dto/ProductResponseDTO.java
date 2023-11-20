package aui.lab.product.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private UUID id;

    private String name;

    private int weight;

    private UUID warehouseId;
}
