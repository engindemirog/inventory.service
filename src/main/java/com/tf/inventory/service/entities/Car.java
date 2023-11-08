package com.tf.inventory.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="modelYear")
    private int modelYear;
    @Column(name="plate")
    private String plate;
    @Column(name="state")
    private int state;
    @Column(name="dailyPrice")
    private double dailyPrice;
    @ManyToOne()
    @JoinColumn(name="model_id")
    private Model model;


    public Car(int modelYear, String plate, int state, double dailyPrice, Model model) {
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
        this.model = model;
    }
}
