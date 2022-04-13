package com.ehsproy.msAccountCustomers.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("AccountData")
public class AccountData {

	@Id
	private String id;
	private String idProduct;
	private String idCustomer;
	private String numAccount;
	private LocalDate dateOpening;
	private String amount;
	private Double balance;
	private Integer maxMovements;
	private Integer numMovements;
	private String numTarget;
	
}
