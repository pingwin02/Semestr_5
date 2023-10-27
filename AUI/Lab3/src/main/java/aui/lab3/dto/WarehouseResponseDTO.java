package aui.lab3.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseResponseDTO {
    private UUID id;

    private String name;

    private int capacity;

}
