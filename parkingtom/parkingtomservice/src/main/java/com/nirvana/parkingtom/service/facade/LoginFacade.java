package com.nirvana.parkingtom.service.facade;
import com.nirvana.parkingtom.dao.LoginAccountDao;
import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.service.dto.AccountDTO;
import com.nirvana.parkingtom.service.dto.LoginRequest;
import com.nirvana.parkingtom.service.exception.AccountNotValidException;
import com.nirvana.parkingtom.service.mapper.LoginMapper;
import com.nirvana.parkingtom.service.util.ContextInitializer;

public class LoginFacade {
	private com.nirvana.parkingtom.dao.LoginAccountDao loginAccountDao = (LoginAccountDao)ContextInitializer.getBean("loginAccountDaoImpl");
	public boolean loginUser(LoginRequest requestObject) {
		// TODO Auto-generated method stub
		
		Account account = (Account)ContextInitializer.getBean("accountBean");
		AccountDTO accountDTO = requestObject.getAccountDTO();
		LoginMapper.map(accountDTO, account);
		if(account == null){
			throw new AccountNotValidException("The given account is not valid");
		}
		return loginAccountDao.loginUser(account);
		
	}

}
