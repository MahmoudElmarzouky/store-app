package com.spring.store.mapper;

import com.spring.store.dto.BillDto;
import com.spring.store.dto.BillDto;
import com.spring.store.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(uses = {EmployeeMapper.class})
public interface BillMapper {
    BillDto mapToBillDto(Bill bill);
    Bill mapToBill(BillDto billDto);
    List<BillDto> mapToBillDto(List<Bill> bills);
}
