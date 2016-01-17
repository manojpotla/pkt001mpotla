package com.nirvana.parkingtom.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.nirvana.parkingtom.service.dto.LoginRequest;
import com.nirvana.parkingtom.service.dto.RequestObject;

public interface LoginService {

	@POST
	@Path("/")
	public Response loginUser(LoginRequest requestObject);
}
