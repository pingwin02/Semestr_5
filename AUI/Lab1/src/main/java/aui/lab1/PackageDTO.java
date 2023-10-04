package aui.lab1;

import lombok.*;

@Getter
@Builder
public class PackageDTO implements Comparable<PackageDTO> {
    String name;
    int weight;
    String warehouseName;

    @Override
    public String toString() {
        return "PackageDTO [name=" + name +
                ", weight=" + weight +
                ", warehouseName=" + warehouseName + "]";
    }

    @Override
    public int compareTo(PackageDTO o) {
        return this.name.compareTo(o.getName());
    }
}
