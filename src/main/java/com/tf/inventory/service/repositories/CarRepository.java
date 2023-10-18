package com.tf.inventory.service.repositories;

import com.tf.inventory.service.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> {
}
