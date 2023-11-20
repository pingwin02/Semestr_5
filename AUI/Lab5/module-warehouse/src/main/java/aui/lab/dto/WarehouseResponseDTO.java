package aui.lab.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseResponseDTO {
    private UUID id;

    private String name;

    private int capacity;

}
