package com.ehsproy.msAccountCustomers.service;

import com.ehsproy.msAccountCustomers.model.AccountData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountDataService {

	Flux<AccountData> findByIdCustomer(String idCustomer);
	
	Mono<AccountData> save(AccountData accountData);
	
	Mono<AccountData> findById(String id);
	
	Mono<AccountData> updateBalance(String id, Double amount);
}
