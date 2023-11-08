package com.tf.inventory.service.repositories.abstracts;


import com.tf.inventory.service.entities.Car;

import java.util.List;

public interface DAO<T> {
    List<T> getAll(T t);
}
