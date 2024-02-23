package com.example.demo.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDTO {
    @NotNull(message = "the product name can not be empty")
    private String productName;
    private String productDescription;
    private String productImage;
    @Positive(message = "price can not be negative or zero")
    private Double price;
    private Integer rate;
    private Integer categoryId;
    private Integer brandId;
}
