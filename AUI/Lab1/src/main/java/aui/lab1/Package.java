package aui.lab1;

import java.io.Serializable;

import lombok.*;

@Getter
@Builder
public class Package implements Serializable, Comparable<Package> {
    String name;
    int weight;
    Warehouse warehouse;

    @Override
    public String toString() {
        return "Package [name=" + name +
                ", weight=" + weight +
                ", warehouse=" + warehouse + "]";
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Package)) {
            return false;
        }
        Package p = (Package) o;
        return name.equals(p.name) &&
                weight == p.weight;
    }

    @Override
    public int compareTo(Package o) {
        return this.name.compareTo(o.getName());
    }
}
