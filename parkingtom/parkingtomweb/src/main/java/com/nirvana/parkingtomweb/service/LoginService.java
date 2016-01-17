package com.nirvana.parkingtomweb.service;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.nirvana.parkingtomweb.beans.LoginBean;
import com.nirvana.parkingtomweb.service.beans.Account;
import com.nirvana.parkingtomweb.service.beans.LoginRequest;


@Service("loginService")
public class LoginService {

	public boolean loginUser(LoginBean loginBean){
		
			Client client = ClientBuilder.newClient();
			
			LoginRequest requestObject = new LoginRequest();
			Account accountDTO = new Account();
			accountDTO.setUserName("mpootla");
			accountDTO.setPassword("hello10");
			accountDTO.setMobileNumber("1233566");
			requestObject.setAccountDTO(accountDTO);
			WebTarget target = client.target("http://localhost:8080/parkingtomservice/services").path("/loginUser/");
			Response loginResponse = target.request().post(Entity.entity(requestObject, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
			return true;
		
	}
}
