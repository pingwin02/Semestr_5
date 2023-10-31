package aui.lab3.dto;

import lombok.*;

import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PackagesResponseDTO {

    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PackageDTO {
        private UUID id;

        private String name;

        private UUID warehouseId;
    }

    private Collection<PackageDTO> packages;
}
