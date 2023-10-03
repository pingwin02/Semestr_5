package aui.lab1;

import lombok.*;

@Getter
@Builder
public class PackageDTO {
    String name;
    int weight;
    String warehouseName;

    public PackageDTO(String name, int weight, String warehouseName) {
        this.name = name;
        this.weight = weight;
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return "PackageDTO [name=" + name +
                ", weight=" + weight +
                ", warehouseName=" + warehouseName + "]";
    }

}
