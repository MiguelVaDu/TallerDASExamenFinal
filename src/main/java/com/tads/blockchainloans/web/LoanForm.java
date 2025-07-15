package com.tads.blockchainloans.web;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanForm {
    // getters y setters
    @Setter
    @Getter
    private String companyName;
    @Setter
    @Getter
    private BigDecimal amount;
    @Setter
    @Getter
    private Double interestRate;
    @Setter
    @Getter
    private LocalDate dueDate;

}

