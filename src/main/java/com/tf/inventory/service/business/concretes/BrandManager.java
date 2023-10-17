package com.tf.inventory.service.business.concretes;

import com.tf.inventory.service.business.abstracts.BrandService;
import com.tf.inventory.service.business.dtos.requests.CreateBrandRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedBrandResponse;
import com.tf.inventory.service.business.rules.BrandBusinessRules;
import com.tf.inventory.service.entities.Brand;
import com.tf.inventory.service.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setId(UUID.randomUUID().toString());

        Brand createdBrand = brandRepository.save(brand);

        CreatedBrandResponse response = new CreatedBrandResponse();
        response.setId(createdBrand.getId());
        response.setName(createdBrand.getName());

        //use search service api....
        //use event sourcing

        return response;
    }
}