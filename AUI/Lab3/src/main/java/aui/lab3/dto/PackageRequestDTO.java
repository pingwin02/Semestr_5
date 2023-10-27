package aui.lab3.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequestDTO {
    private String name;

    private int weight;

    private UUID warehouseId;
}
