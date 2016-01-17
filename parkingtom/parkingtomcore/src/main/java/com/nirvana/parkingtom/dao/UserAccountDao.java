package com.nirvana.parkingtom.dao;

import org.springframework.stereotype.Component;

import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.entities.UserAccount;

@Component
public interface UserAccountDao {

	public int registerUser(Account account, UserAccount userAccount);
	
	public UserAccount findUser(String userName);

}
