package aui.lab.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRequestDTO {
    private String name;

    private int capacity;
}
