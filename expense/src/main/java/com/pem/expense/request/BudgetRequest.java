package com.pem.expense.request;

import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BudgetRequest {
	
    private String category;
    private BigDecimal amount;
    private LocalDate fromDate;
    private LocalDate toDate;

}
