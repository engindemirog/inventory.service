package com.tf.inventory.service.business.rules;

import com.tf.inventory.service.repositories.BrandRepository;
import com.tf.inventory.service.utils.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void  checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByNameIgnoreCase(name)){
            throw new BusinessException("Brand name exists");//No magic strings!!!
        }
    }
}
