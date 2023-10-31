package aui.lab3.function;

import aui.lab3.dto.WarehousesResponseDTO;
import aui.lab3.entity.Warehouse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class WarehousesToResponse implements Function<Collection<Warehouse>, WarehousesResponseDTO> {

    @Override
    public WarehousesResponseDTO apply(Collection<Warehouse> warehouses) {
        return WarehousesResponseDTO.builder()
                .warehouses(warehouses.stream()
                        .map(warehouse -> WarehousesResponseDTO.WarehouseDTO.builder()
                                .id(warehouse.getId())
                                .name(warehouse.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }


}
