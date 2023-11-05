package aui.lab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
public class Warehouse implements Serializable {

    @Id
    private UUID id;

    private String name;

    private int capacity;

}