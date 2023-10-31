package aui.lab3.function;

import aui.lab3.dto.PackagesResponseDTO;
import aui.lab3.entity.Package;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PackagesToResponse implements Function<Collection<Package>, PackagesResponseDTO> {

    @Override
    public PackagesResponseDTO apply(Collection<Package> packages) {
        return PackagesResponseDTO.builder()
                .packages(packages.stream()
                        .map(pack -> PackagesResponseDTO.PackageDTO.builder()
                                .id(pack.getId())
                                .name(pack.getName())
                                .warehouseId(pack.getWarehouse().getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }


}
