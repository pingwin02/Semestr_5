package aui.lab.dto;

import lombok.*;

import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WarehousesResponseDTO {

    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WarehouseDTO {
        private UUID id;

        private String name;
    }

    Collection<WarehouseDTO> warehouses;

}
