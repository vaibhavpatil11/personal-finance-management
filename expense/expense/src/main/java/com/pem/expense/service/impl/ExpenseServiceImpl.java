package com.pem.expense.service.impl;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pem.expense.client.NotificationClient;
import com.pem.expense.model.Budget;
import com.pem.expense.model.Expense;
import com.pem.expense.model.Notification;
import com.pem.expense.repository.BudgetRepository;
import com.pem.expense.repository.ExpenseRepository;
import com.pem.expense.request.ExpenseRequest;
import com.pem.expense.response.ExpenseResponse;
import com.pem.expense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	BudgetRepository budgetRepository;

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	NotificationClient notificationClient;

	@Override
	public ExpenseResponse addExpense(ExpenseRequest request) {

		if (request != null && request.getCategory() != null && request.getAmount() > 0) {

			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			Expense expense = modelMapper.map(request, Expense.class);
			expense.setExpenseDate(LocalDate.now());
			expense = expenseRepository.save(expense);
			ExpenseResponse expenseResponse = modelMapper.map(expense, ExpenseResponse.class);

			double totalBudget = getTotalBudget(request);
			double totalExpense = getTotalExpense(request);

			if (totalBudget < totalExpense) {
				// Send Notification
				Notification notification=new Notification();
				notification.setBudgetAmount(totalBudget);
				notification.setExpenseAmount(totalExpense);
				notification.setBudgetCategory(request.getCategory());
				boolean isNotificationSend=notificationClient.sendNotification(notification);
				System.out.println("sending notification : " + isNotificationSend );
			}

			return expenseResponse;
		}

		return null;

	}

	private double getTotalExpense(ExpenseRequest request) {
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.with(TemporalAdjusters.lastDayOfMonth());
		List<Expense> expenses = expenseRepository
				.findByCategoryAndFromDateGreaterThanEqualAndToDateLessThanEqual(request.getCategory(), start, end);
		double totalExpense = 0;
		for (Expense e : expenses) {
			totalExpense += e.getAmount();
		}
		return totalExpense;
	}

	private double getTotalBudget(ExpenseRequest request) {
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.with(TemporalAdjusters.lastDayOfMonth());
		List<Budget> budgets = budgetRepository
				.findByCategoryAndFromDateGreaterThanEqualAndToDateLessThanEqual(request.getCategory(), start, end);
		double totalBudget = 0;
		for (Budget b : budgets) {
			totalBudget += b.getAmount();
		}
		return totalBudget;
	}

}
