package com.pem.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pem.expense.request.ExpenseRequest;
import com.pem.expense.response.ExpenseResponse;
import com.pem.expense.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@PostMapping("/add")
	public ExpenseResponse addExpense(@RequestBody ExpenseRequest expense) {
		return expenseService.addExpense(expense);
	}

}
