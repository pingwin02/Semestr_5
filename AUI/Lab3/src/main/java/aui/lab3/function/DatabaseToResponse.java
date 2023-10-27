package aui.lab3.function;

import aui.lab3.dto.DatabaseResponseDTO;
import org.springframework.stereotype.Component;
import aui.lab3.entity.Warehouse;

import java.util.function.Function;

@Component
public class DatabaseToResponse implements Function<Warehouse, DatabaseResponseDTO> {

    @Override
    public DatabaseResponseDTO apply(Warehouse warehouse) {
        return DatabaseResponseDTO.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .capacity(warehouse.getCapacity())
                .packages(warehouse.getPackages().stream().map(new PackageToResponse()).toList())
                .build();
    }


}
