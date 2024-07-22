package com.pem.expense.request;

import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequest {
	
    private String category;
    private double amount;
    private LocalDate fromDate;
    private LocalDate toDate;

}
