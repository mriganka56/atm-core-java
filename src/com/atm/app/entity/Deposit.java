package com.atm.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {

	private Long amount;
	private Integer atmPin;
	private Long accountNumber;

}
