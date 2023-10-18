package com.tf.inventory.service.business.concretes;

import com.tf.events.inventories.InventoryCreatedEvent;
import com.tf.inventory.service.business.abstracts.CarService;
import com.tf.inventory.service.business.dtos.requests.CreateCarRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedCarResponse;
import com.tf.inventory.service.entities.Car;
import com.tf.inventory.service.entities.Model;
import com.tf.inventory.service.kafka.producers.InventoryProducer;
import com.tf.inventory.service.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private InventoryProducer inventoryProducer;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        //business rules

        Car car = new Car();
        car.setDailyPrice(createCarRequest.getDailyPrice());
        car.setPlate(createCarRequest.getPlate());
        car.setState(1);
        car.setModelYear(createCarRequest.getModelYear());

        Model model = new Model();
        model.setId(createCarRequest.getModelId());
        car.setModel(model);

        car.setId(UUID.randomUUID().toString());

        Car createdCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = new CreatedCarResponse();
        createdCarResponse.setId(createdCar.getId());
        createdCarResponse.setState(createdCar.getState());
        createdCarResponse.setPlate(createdCar.getPlate());
        createdCarResponse.setModelYear(createdCar.getModelYear());
        createdCarResponse.setDailyPrice(createdCar.getDailyPrice());
        createdCarResponse.setModelId(createdCar.getModel().getId());

        createInventoryCreatedEvent(createdCar);

        return createdCarResponse;
    }

    private void createInventoryCreatedEvent(Car createdCar) {
        InventoryCreatedEvent inventoryCreatedEvent = new InventoryCreatedEvent();
        inventoryCreatedEvent.setCarId(createdCar.getId());
        inventoryCreatedEvent.setPlate(createdCar.getPlate());
        inventoryCreatedEvent.setState(createdCar.getState());
        inventoryCreatedEvent.setDailyPrice(createdCar.getDailyPrice());
        inventoryCreatedEvent.setModelYear(createdCar.getModelYear());
        inventoryCreatedEvent.setModelId(createdCar.getModel().getId());
        inventoryCreatedEvent.setBrandId(createdCar.getModel().getBrand().getId());
        inventoryCreatedEvent.setBrandName(createdCar.getModel().getBrand().getName());
        inventoryCreatedEvent.setModelName(createdCar.getModel().getName());

        this.inventoryProducer.sendMessage(inventoryCreatedEvent);
    }
}
