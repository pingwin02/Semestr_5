package aui.lab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "packages")
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Package implements Comparable<Package> {
    @Id
    private UUID id;

    private String name;

    private int weight;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Override
    public int compareTo(Package o) {
        return this.name.compareTo(o.name);
    }
}