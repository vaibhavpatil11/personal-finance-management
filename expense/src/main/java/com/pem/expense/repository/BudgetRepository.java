package com.pem.expense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pem.expense.model.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

	public List<Budget> findByCategoryAndFromDateGreaterThanEqualAndToDateLessThanEqual(String category,
			LocalDate fromDate, LocalDate toDate);
}
