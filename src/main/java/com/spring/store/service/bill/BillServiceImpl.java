package com.spring.store.service.bill;

import com.spring.store.dto.BillDto;
import com.spring.store.entity.Bill;
import com.spring.store.exception.EntityNotFoundException;
import com.spring.store.mapper.BillMapper;
import com.spring.store.repository.bill.BillRepository;
import com.spring.store.service.bill.BillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    private BillMapper billMapper;
    private BillRepository billRepository;

    public BillServiceImpl(BillMapper billMapper, BillRepository billRepository) {
        this.billMapper = billMapper;
        this.billRepository = billRepository;
    }

    @Override
    public List<BillDto> findAll() {
        return billMapper.mapToBillDto(billRepository.findAll());
    }

    @Override
    public BillDto save(BillDto billDto) {
        billDto.setId(0L);
        Bill bill= billRepository.save(billMapper.mapToBill(billDto));
        return billMapper.mapToBillDto(bill);
    }

    @Override
    public BillDto findById(Long id) {
        Optional<Bill> bill=billRepository.findById(id);
        if(!bill.isPresent())
            throw new EntityNotFoundException("no bill with id :"+id);
        return billMapper.mapToBillDto(bill.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Bill> bill=billRepository.findById(id);
        if(!bill.isPresent())
            throw new EntityNotFoundException("can not delete , no bill with id :"+id);
        billRepository.deleteById(id);
    }

    @Override
    public BillDto update(BillDto billDto) {
        Optional<Bill> bill=billRepository.findById(billDto.getId());
        if(!bill.isPresent())
            throw new EntityNotFoundException("can not update,no bill with id :"+billDto.getId());
        Bill billUpdated= billRepository.save(billMapper.mapToBill(billDto));
        return billMapper.mapToBillDto(billUpdated);
    }
}
