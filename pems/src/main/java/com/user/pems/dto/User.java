package com.user.pems.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
    private String id;
    private String email;
    private String username;
    private String password;
    private String dateJoined;
    private List<Account> accounts;
    private List<Expense> expenses;
    private List<Loan> loans;

}
