package com.spring.store.repository.salaryHistory;

import com.spring.store.entity.SalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryHistoryRepository extends JpaRepository<SalaryHistory,Long> {
}
