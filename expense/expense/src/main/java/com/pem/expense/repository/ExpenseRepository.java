package com.pem.expense.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pem.expense.model.Budget;
import com.pem.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	

	public List<Expense> findByCategoryAndFromDateGreaterThanEqualAndToDateLessThanEqual(String category,
			LocalDate fromDate, LocalDate toDate);
}
