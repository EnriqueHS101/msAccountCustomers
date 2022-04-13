package com.ehsproy.msAccountCustomers.service.impl;

import org.springframework.stereotype.Service;

import com.ehsproy.msAccountCustomers.model.AccountData;
import com.ehsproy.msAccountCustomers.repository.IAccountDataRepository;
import com.ehsproy.msAccountCustomers.service.IAccountDataService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountDataServiceImpl implements IAccountDataService {

	private final IAccountDataRepository accountRepo;

	
	public Flux<AccountData> findByIdCustomer(String idCustomer) {
		return accountRepo.findByIdCustomer(idCustomer);
	}


	public Mono<AccountData> save(AccountData accountData) {
		return accountRepo.save(accountData);
	}

	public Mono<AccountData> findById(String id) {
		return accountRepo.findById(id);
	}
	
	public Mono<AccountData> updateBalance(String id, Double amount){
		Mono<AccountData> accountData = accountRepo.findById(id);
		
		return accountData.flatMap(ac ->{
			ac.setBalance(ac.getBalance() + amount);
			
			return accountRepo.save(ac);
		} );
	}
}
