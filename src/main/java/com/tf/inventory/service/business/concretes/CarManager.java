package com.tf.inventory.service.business.concretes;

import com.tf.inventory.service.business.abstracts.CarService;
import com.tf.inventory.service.business.dtos.requests.CreateCarRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedCarResponse;

public class CarManager implements CarService {
    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        return null;
    }
}
