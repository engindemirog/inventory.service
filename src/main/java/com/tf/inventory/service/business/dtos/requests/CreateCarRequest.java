package com.tf.inventory.service.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotBlank
    private String modelId;
    @Min(value=2000)
    private int modelYear;
    @NotNull
    @NotBlank
    private String plate;
    @Min(value=0)
    private double dailyPrice;
}
