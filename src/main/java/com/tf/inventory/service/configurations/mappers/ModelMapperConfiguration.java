package com.tf.inventory.service.configurations.mappers;

import com.tf.inventory.service.common.mapping.ModelMapperManager;
import com.tf.inventory.service.common.mapping.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper){
        return new ModelMapperManager(mapper);
    }
}
