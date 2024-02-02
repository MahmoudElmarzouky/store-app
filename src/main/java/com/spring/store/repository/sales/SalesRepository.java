package com.spring.store.repository.sales;

import com.spring.store.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {

}
