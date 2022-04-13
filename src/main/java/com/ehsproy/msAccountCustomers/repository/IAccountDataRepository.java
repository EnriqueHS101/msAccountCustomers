package com.ehsproy.msAccountCustomers.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ehsproy.msAccountCustomers.model.AccountData;

import reactor.core.publisher.Flux;

public interface IAccountDataRepository extends ReactiveCrudRepository<AccountData,String> {

	
	Flux<AccountData> findByIdCustomer(String idCustomer);
	
}
