package aui.lab3.function;

import aui.lab3.entity.Warehouse;
import org.springframework.stereotype.Component;
import aui.lab3.entity.Package;
import aui.lab3.dto.PackageRequestDTO;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToPackage implements Function<PackageRequestDTO, Package> {

    @Override
    public Package apply(PackageRequestDTO packageRequestDTO) {
        return Package.builder()
                .id(UUID.randomUUID())
                .name(packageRequestDTO.getName())
                .weight(packageRequestDTO.getWeight())
                .warehouse(Warehouse
                        .builder()
                        .id(packageRequestDTO
                                .getWarehouseId())
                        .build())
                .build();
    }


}
