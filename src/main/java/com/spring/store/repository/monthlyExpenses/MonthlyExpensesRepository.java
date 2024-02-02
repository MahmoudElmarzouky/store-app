package com.spring.store.repository.monthlyExpenses;

import com.spring.store.entity.MonthlyExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyExpensesRepository extends JpaRepository <MonthlyExpenses,Long> {
}
