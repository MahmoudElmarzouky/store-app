package com.spring.store.repository.bill;

import com.spring.store.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill,Long> {
    Optional<Bill> findTopByOrderByDateTimeDesc();
}
