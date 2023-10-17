package com.tf.inventory.service.repositories;


import com.tf.inventory.service.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand,String> {
    boolean existsByNameIgnoreCase(String name);
    //jpql
    //native query
}
