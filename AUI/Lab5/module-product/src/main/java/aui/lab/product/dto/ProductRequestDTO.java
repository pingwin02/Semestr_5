package aui.lab.product.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String name;

    private int weight;

    private UUID warehouseId;
}
