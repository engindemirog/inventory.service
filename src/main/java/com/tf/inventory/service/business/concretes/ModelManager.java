package com.tf.inventory.service.business.concretes;

import com.tf.inventory.service.business.abstracts.ModelService;
import com.tf.inventory.service.business.dtos.requests.CreateModelRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedModelResponse;
import com.tf.inventory.service.common.mapping.ModelMapperService;
import com.tf.inventory.service.entities.Brand;
import com.tf.inventory.service.entities.Model;
import com.tf.inventory.service.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {

        Model model = modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setId(UUID.randomUUID().toString());

        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());

        model.setBrand(brand);

        Model createdModel = this.modelRepository.save(model);

        CreatedModelResponse response = modelMapperService.forRequest().map(createdModel,CreatedModelResponse.class);
        return response;
    }
}

//Inventory-Envanter-Stok---RDBMS--Data Integrity
//Search-Filter --ElasticSearch--Mongo--NoSql--