package aui.lab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "warehouses")
public class Warehouse implements Serializable {

    @Id
    private UUID id;

    private String name;

    private int capacity;

}