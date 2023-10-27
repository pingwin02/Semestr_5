package aui.lab3.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRequestDTO {
    private String name;

    private int capacity;
}
