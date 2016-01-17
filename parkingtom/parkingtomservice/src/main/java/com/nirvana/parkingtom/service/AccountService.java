package com.nirvana.parkingtom.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonIgnore;


import com.nirvana.parkingtom.service.dto.RequestObject;

@Produces({"application/json"})
@Consumes({"application/xml"})
public interface AccountService {

	@GET
	@Path("/{userName}")
	@JsonIgnore
	public com.nirvana.parkingtom.entities.UserAccount findUserAccount(@PathParam("userName") String userName);
	
	@POST
	@Path("/")
	public Response createUserAccount(RequestObject requestObject);
}
