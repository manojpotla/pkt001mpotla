package com.nirvana.parkingtom.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nirvana.parkingtom.service.dto.RequestObject;
import com.nirvana.parkingtom.service.facade.UserAccountFacade;
import com.nirvana.parkingtom.service.util.ContextInitializer;
import com.nirvana.parkingtom.dao.*;
import com.nirvana.parkingtom.entities.UserAccount;

@Service
public class AccountServiceImpl implements AccountService {

	//@Autowired	
	private com.nirvana.parkingtom.dao.UserAccountDao userAccountDao = (UserAccountDao)ContextInitializer.getBean("userAccountDaoImpl");
	
	@Autowired 
	private UserAccountFacade userAccountFacade = new UserAccountFacade();

	

	public Response createUserAccount(RequestObject requestObject) {
		
		boolean status = userAccountFacade.createNewUser(requestObject);
		if(status)
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	public UserAccount findUserAccount(String userName) {
		com.nirvana.parkingtom.entities.UserAccount userAccount = (UserAccount)userAccountDao.findUser(userName);
		return userAccount;
	}

}
