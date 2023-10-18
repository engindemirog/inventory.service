package com.tf.inventory.service.api.controllers;

import com.tf.inventory.service.business.abstracts.CarService;
import com.tf.inventory.service.business.dtos.requests.CreateCarRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return this.carService.add(createCarRequest);
    }
}
