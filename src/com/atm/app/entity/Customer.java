package com.atm.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private String name;
	private String email;
	private Integer atmPin;
	private String password;
	private Long phoneNumber;
	private Long accountNumber;
	private Long accountBalance;

}
