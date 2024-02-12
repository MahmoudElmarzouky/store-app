package com.spring.store.mapper;

import com.spring.store.dto.SalesDto;
import com.spring.store.entity.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SalesMapper {
    @Mapping(source = "bill.id",target = "billId")
    @Mapping(source = "product.id",target = "productId")
    @Mapping(source = "customer.id",target = "customerId")
    SalesDto mapToSalesDto(Sales sales);
    @Mapping(source = "billId",target = "bill.id")
    @Mapping(source = "productId",target = "product.id")
    @Mapping(source = "customerId",target = "customer.id")
    Sales mapToSales(SalesDto salesDto);
    List<SalesDto> mapToSalesDtos(List<Sales> sales);
}
