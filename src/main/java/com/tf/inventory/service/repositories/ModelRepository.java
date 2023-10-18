package com.tf.inventory.service.repositories;

import com.tf.inventory.service.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,String> {
    boolean existsByNameIgnoreCase(String name);
}
