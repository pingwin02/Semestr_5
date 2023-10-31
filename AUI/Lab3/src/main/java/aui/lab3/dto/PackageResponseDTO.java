package aui.lab3.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PackageResponseDTO {
    private UUID id;

    private String name;

    private int weight;

    private UUID warehouseId;
}
