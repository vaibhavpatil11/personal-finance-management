package com.pem.expense.service;

import com.pem.expense.request.ExpenseRequest;
import com.pem.expense.response.ExpenseResponse;

public interface ExpenseService {
	
	public ExpenseResponse addExpense(ExpenseRequest request);

}
