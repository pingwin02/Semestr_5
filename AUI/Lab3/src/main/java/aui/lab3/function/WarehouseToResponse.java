package aui.lab3.function;

import org.springframework.stereotype.Component;
import aui.lab3.entity.Warehouse;
import aui.lab3.dto.WarehouseResponseDTO;

import java.util.function.Function;

@Component
public class WarehouseToResponse implements Function<Warehouse, WarehouseResponseDTO> {

    @Override
    public WarehouseResponseDTO apply(Warehouse warehouse) {
        return WarehouseResponseDTO.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .capacity(warehouse.getCapacity())
                .build();
    }


}
