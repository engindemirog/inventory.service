package com.tf.inventory.service.business.abstracts;

import com.tf.inventory.service.business.dtos.requests.CreateModelRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedModelResponse;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
}
