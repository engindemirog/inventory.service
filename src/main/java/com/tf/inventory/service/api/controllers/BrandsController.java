package com.tf.inventory.service.api.controllers;

import com.tf.inventory.service.business.abstracts.BrandService;
import com.tf.inventory.service.business.dtos.requests.CreateBrandRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return this.brandService.add(createBrandRequest);
    }
}
