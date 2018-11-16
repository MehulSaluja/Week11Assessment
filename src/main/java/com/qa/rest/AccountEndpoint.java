package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/classroom")

public class AccountEndpoint 
{
	
	@Inject
	private AccountService service;
	
	@Path ("/json")
	@GET
	@Produces ({"application/json"})
	public String getAllClassroom() 
	{
		return service.getAllClassroom();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String account) {
		return service.addClassroom(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long id, String account) {
		return service.updateClassroom(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
		return service.deleteClassroom(id);

	}

	public void setService(AccountService service) {
		this.service = service;
	}

}
