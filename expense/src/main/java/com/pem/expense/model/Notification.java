package com.pem.expense.model;

import lombok.Data;

@Data
public class Notification {
	private String budgetCategory;
	private double budgetAmount;
	private double expenseAmount;

}