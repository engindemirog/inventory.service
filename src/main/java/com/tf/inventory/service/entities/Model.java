package com.tf.inventory.service.entities;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="models")
public class Model {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
