package com.ehsproy.msAccountCustomers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msAccountCustomers.model.AccountData;
import com.ehsproy.msAccountCustomers.service.IAccountDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountDataController {

	private final IAccountDataService accountService;
	
	@GetMapping("/bycustomer/{idCustomer}")
	public Flux<AccountData> findByIdCustomer(@PathVariable("idCustomer") String idCustomer) {
		return accountService.findByIdCustomer(idCustomer);
	}

	@PostMapping
	public Mono<AccountData> save(@RequestBody AccountData accountData) {
		return accountService.save(accountData);
	}

	@PutMapping
	public Mono<AccountData> update(@RequestBody AccountData accountData) {
		return accountService.save(accountData);
	}
	
	@GetMapping("/{id}")
	public Mono<AccountData> findById(@PathVariable String id) {
		return accountService.findById(id);
	}
	
	@PutMapping("/balance/{id}")
	public ResponseEntity<Mono<AccountData>> updateBalance(@PathVariable String id, @RequestParam Double amount){
		log.info("Aqui en Controller de Account");
		Mono<AccountData> account = accountService.updateBalance(id, amount);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(account);
		
	}
}
