package com.nirvana.parkingtom.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nirvana.parkingtom.service.dto.AccountDTO;
import com.nirvana.parkingtom.service.dto.LoginRequest;
import com.nirvana.parkingtom.service.dto.RequestObject;
import com.nirvana.parkingtom.service.facade.LoginFacade;
import com.nirvana.parkingtom.service.facade.UserAccountFacade;

public class LoginServiceImpl implements LoginService {
	private LoginFacade loginFacade = new LoginFacade();
	public Response loginUser(LoginRequest requestObject) {
		boolean status = loginFacade.loginUser(requestObject);
	
		if(status == true){
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.UNAUTHORIZED).build();
	}

}
