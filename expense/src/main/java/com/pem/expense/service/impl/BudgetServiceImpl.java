package com.pem.expense.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pem.expense.model.Budget;
import com.pem.expense.repository.BudgetRepository;
import com.pem.expense.request.BudgetRequest;
import com.pem.expense.response.BudgetResponse;
import com.pem.expense.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	BudgetRepository budgetRepository;


	@Override
	public BudgetResponse createBudget(BudgetRequest request) {

		if (request != null && request.getToDate() != null && request.getFromDate() != null
				&& request.getCategory() != null && request.getAmount() != null
				&& request.getToDate().isAfter(request.getFromDate())) {
			ModelMapper modelMapper = new ModelMapper();
			Budget budget = modelMapper.map(request, Budget.class);
			budget.setCreatedDate(LocalDate.now());
			budget = budgetRepository.save(budget);
			return modelMapper.map(budget, BudgetResponse.class);
		}
		return null;
	}

}
