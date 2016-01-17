package com.nirvana.parkingtom.service.mapper;

import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.service.dto.AccountDTO;

public class LoginMapper {

	public static void map(AccountDTO accountDTO, Account account) {
		// TODO Auto-generated method stub
		account.setUserName(accountDTO.getUserName());
		account.setPassword(accountDTO.getPassword());
		
	}

}
