package com.example.demo.model.mapper;

import com.example.demo.model.dto.ProductReqDTO;
import com.example.demo.model.dto.ProductResDTO;
import com.example.demo.model.dto.ProductUpdateReqDTO;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductUpdateReqDTO dto);
    Product toEntity(ProductReqDTO dto);
    ProductResDTO toResDTO(Product product);
}
