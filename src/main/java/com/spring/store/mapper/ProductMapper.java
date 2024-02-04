package com.spring.store.mapper;

import com.spring.store.dto.ProductDto;
import com.spring.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(source = "category",target = "categoryDto")
    ProductDto mapToProductDto(Product product);
    @Mapping(source = "categoryDto",target = "category")
    Product mapToProduct(ProductDto productDto);
    List<ProductDto> mapToProductDtos(List<Product> products);
}
