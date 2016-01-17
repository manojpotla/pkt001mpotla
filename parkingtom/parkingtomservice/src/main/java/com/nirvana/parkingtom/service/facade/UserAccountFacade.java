package com.nirvana.parkingtom.service.facade;


import org.springframework.stereotype.Component;

import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.entities.UserAccount;
import com.nirvana.parkingtom.service.dto.RequestObject;
import com.nirvana.parkingtom.service.exception.AccountNotValidException;
import com.nirvana.parkingtom.service.mapper.AccountsMapper;
import com.nirvana.parkingtom.service.mapper.UserAccountMapper;
import com.nirvana.parkingtom.service.util.ContextInitializer;
import com.nirvana.parkingtom.dao.*;

@Component("userAccountFacade")
public class UserAccountFacade {
	private com.nirvana.parkingtom.dao.UserAccountDao userAccountDao = (UserAccountDao)ContextInitializer.getBean("userAccountDaoImpl");
	
	private com.nirvana.parkingtom.entities.UserAccount userAccount;
	private com.nirvana.parkingtom.entities.Account accounts;//= new Accounts(); 
	
	public boolean createNewUser(RequestObject requestObject){
		accounts = (Account)ContextInitializer.getBean("accountBean");
		userAccount = (UserAccount)ContextInitializer.getBean("userAccountBean");
		AccountsMapper.mapAccounts(accounts, requestObject.getAccountDTO());
		UserAccountMapper.mapUserAccount(userAccount, requestObject.getUserAccountDTO());
		if(accounts == null){
			throw new AccountNotValidException("The given account is not valid");
		}
		//UserAccount accounts2 = userAccountDao.findUser(accounts.getUserName());			
	
		//if(accounts2 ==  null){
			//throw new AccountNotValidException("The given account is not valid");
		//}
		//accounts.setUserAccount(userAccount);
		userAccount.setAccount(accounts);
		int status = userAccountDao.registerUser(accounts, userAccount);
		if(status > 0)
			return true;
		else
			return false;
	}
}
