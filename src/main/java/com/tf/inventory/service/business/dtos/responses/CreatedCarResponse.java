package com.tf.inventory.service.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCarResponse {
    private String id;
    private String modelId;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    private int state;
}
