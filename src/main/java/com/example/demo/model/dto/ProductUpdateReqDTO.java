package com.example.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateReqDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private Double  price;
    private Integer rate;
    private Integer categoryId;
    private Integer brandId;
}
