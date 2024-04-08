package com.user.pems.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    private String loanNo;
    private double loanAmount;
    private String loanType;
    private double interest;
    private double balanceAmount;
    private String startDate;
    private String endDate;
    
    // Getters and setters
}

