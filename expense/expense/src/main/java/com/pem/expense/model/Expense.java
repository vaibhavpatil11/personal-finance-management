package com.pem.expense.model;

import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private double amount;
    private LocalDate expenseDate;
    private LocalDate fromDate;
    private LocalDate toDate;

}
