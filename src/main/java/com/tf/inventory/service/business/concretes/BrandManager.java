package com.tf.inventory.service.business.concretes;

import com.tf.events.inventories.BrandCreatedEvent;
import com.tf.inventory.service.business.abstracts.BrandService;
import com.tf.inventory.service.business.dtos.requests.CreateBrandRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedBrandResponse;
import com.tf.inventory.service.business.rules.BrandBusinessRules;
import com.tf.inventory.service.common.mapping.ModelMapperService;
import com.tf.inventory.service.entities.Brand;
import com.tf.inventory.service.kafka.producers.InventoryProducer;
import com.tf.inventory.service.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;
    private ModelMapperService modelMapperService;
    private InventoryProducer inventoryProducer;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setId(UUID.randomUUID().toString());

        Brand createdBrand = brandRepository.save(brand);

        CreatedBrandResponse response = modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);

        //BrandCreatedEvent brandCreatedEvent = modelMapperService.forResponse().map(createdBrand,BrandCreatedEvent.class);
        //inventoryProducer.sendMessage(brandCreatedEvent);

        return response;
    }
}