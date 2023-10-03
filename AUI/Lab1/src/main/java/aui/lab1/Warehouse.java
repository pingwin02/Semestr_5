package aui.lab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Warehouse implements Serializable {
    String name;
    int capacity;
    List<Package> packages;

    public Warehouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addPackage(Package p) {
        if (packages == null) {
            packages = new ArrayList<>();
        }
        if (capacity - p.getWeight() >= 0) {
            packages.add(p);
            capacity -= p.getWeight();
        } else {
            System.out.println("Warehouse " + name + " is full!");
        }
    }

    @Override
    public String toString() {
        return "Warehouse [name=" + name +
                ", capacity=" + capacity + "]";
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Warehouse)) {
            return false;
        }
        Warehouse w = (Warehouse) o;
        return name.equals(w.name) &&
                capacity == w.capacity;
    }

}

