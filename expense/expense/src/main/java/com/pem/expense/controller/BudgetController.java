package com.pem.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pem.expense.model.Budget;
import com.pem.expense.repository.BudgetRepository;
import com.pem.expense.request.BudgetRequest;
import com.pem.expense.response.BudgetResponse;
import com.pem.expense.service.BudgetService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

	@Autowired
	private BudgetService budgetService;

	@PostMapping("/create")
	public BudgetResponse createBudget(@RequestBody BudgetRequest budget) {
		return budgetService.createBudget(budget);
	}

}
