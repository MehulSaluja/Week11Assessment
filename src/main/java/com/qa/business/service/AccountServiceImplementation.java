package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

//import com.qa.business.service.AccountService;
import com.qa.persistence.repository.ClassroomRepository;

public class AccountServiceImplementation implements AccountService
{
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);
	
	@Inject
	private ClassroomRepository repo;
	
	public String getAllClassroom() {
		LOGGER.info("In AccountServiceImplementation getAllAccounts ");
		return repo.getAllClassroom();
	}

	@Override
	public String addClassroom(String account) {
		return repo.addClassroom(account);
	}

	@Override
	public String updateClassroom(Long id, String account) {
		return repo.updateClassroom(id, account);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);

	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
		
	}


}
