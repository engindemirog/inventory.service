package com.tf.inventory.service.repositories.concretes;

import com.tf.inventory.service.entities.Car;
import com.tf.inventory.service.repositories.abstracts.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDAO implements DAO<Car> {

    private EntityManager entityManager;

    @Autowired
    public CarDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> getAll(Car car) {
        //JPQL option
        TypedQuery<Car> query= entityManager.createQuery("FROM Car", Car.class);
        return query.getResultList();
    }
}
