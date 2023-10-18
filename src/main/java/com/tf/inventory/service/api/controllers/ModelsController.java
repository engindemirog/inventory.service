package com.tf.inventory.service.api.controllers;

import com.tf.inventory.service.business.abstracts.ModelService;
import com.tf.inventory.service.business.dtos.requests.CreateModelRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelsController {
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        //no business
        return modelService.add(createModelRequest);
    }
}
