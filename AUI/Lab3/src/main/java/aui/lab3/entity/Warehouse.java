package aui.lab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "warehouses")
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Warehouse implements Comparable<Warehouse>, Serializable {

    @Id
    private UUID id;

    private String name;

    private int capacity;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Package> packages;

    @Override
    public int compareTo(Warehouse o) {
        return this.name.compareTo(o.name);

    }
}