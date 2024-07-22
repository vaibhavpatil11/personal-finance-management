package com.pem.expense.service;

import com.pem.expense.request.BudgetRequest;
import com.pem.expense.response.BudgetResponse;

public interface BudgetService {
	
	public BudgetResponse createBudget(BudgetRequest request);

}
