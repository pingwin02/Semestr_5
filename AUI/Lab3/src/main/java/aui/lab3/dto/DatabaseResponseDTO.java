package aui.lab3.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseResponseDTO {
    private UUID id;

    private String name;

    private int capacity;

    private List<PackageResponseDTO> packages;

}
