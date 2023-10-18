package com.tf.inventory.service.business.abstracts;

import com.tf.inventory.service.business.dtos.requests.CreateCarRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);
}
