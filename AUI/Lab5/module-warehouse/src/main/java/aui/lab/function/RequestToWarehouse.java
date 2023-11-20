package aui.lab.function;

import org.springframework.stereotype.Component;
import aui.lab.entity.Warehouse;
import aui.lab.dto.WarehouseRequestDTO;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToWarehouse implements Function<WarehouseRequestDTO, Warehouse> {

    @Override
    public Warehouse apply(WarehouseRequestDTO warehouseRequestDTO) {
        return Warehouse.builder()
                .id(UUID.randomUUID())
                .name(warehouseRequestDTO.getName())
                .capacity(warehouseRequestDTO.getCapacity())
                .build();
    }

}
