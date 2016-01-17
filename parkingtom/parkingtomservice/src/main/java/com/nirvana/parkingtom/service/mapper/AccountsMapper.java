package com.nirvana.parkingtom.service.mapper;

import java.util.Calendar;

import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.service.dto.AccountDTO;
import com.nirvana.parkingtom.service.util.ContextInitializer;

public class AccountsMapper {
	public static void mapAccounts(Account accounts, AccountDTO accountDTO){
		
		if(accountDTO != null){
			if(isValid(accountDTO)){
				//accounts  = (Accounts)ContextInitializer.getBean("accountsBean");//= new Accounts();
				accounts.setPassword(accountDTO.getPassword());
				accounts.setUserName(accountDTO.getUserName());
				accounts.setCreatedDate(Calendar.getInstance().getTime());
				accounts.setLastUpdatedDate(Calendar.getInstance().getTime());
				accounts.setQuestion1(accountDTO.getSecurityQuestion());
				accounts.setAnswer1(accountDTO.getSecurityAnswer());
			}
		}
	}

	private static boolean isValid(AccountDTO accountDTO) {
		if(accountDTO.getPassword() != null && accountDTO.getUserName() != null){
			return true;
		}
		return false;
	}
}
