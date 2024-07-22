package com.pem.expense.response;

import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseResponse {
	
    private String category;
    private BigDecimal amount;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate createdDate;

}
