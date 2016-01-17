package com.nirvana.parkingtom.dao;

import org.springframework.stereotype.Component;

import com.nirvana.parkingtom.entities.Account;

@Component
public interface LoginAccountDao {

	public boolean loginUser(Account account);

	//public boolean validateUser(Account account);
}
