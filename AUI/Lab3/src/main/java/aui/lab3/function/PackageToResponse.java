package aui.lab3.function;

import org.springframework.stereotype.Component;
import aui.lab3.entity.Package;
import aui.lab3.dto.PackageResponseDTO;

import java.util.function.Function;

@Component
public class PackageToResponse implements Function<Package, PackageResponseDTO> {

    @Override
    public PackageResponseDTO apply(Package Package) {
        return PackageResponseDTO.builder()
                .id(Package.getId())
                .name(Package.getName())
                .weight(Package.getWeight())
                .warehouseId(Package.getWarehouse().getId())
                .build();
    }
}
