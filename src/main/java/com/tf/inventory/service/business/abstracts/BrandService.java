package com.tf.inventory.service.business.abstracts;

import com.tf.inventory.service.business.dtos.requests.CreateBrandRequest;
import com.tf.inventory.service.business.dtos.responses.CreatedBrandResponse;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
}
