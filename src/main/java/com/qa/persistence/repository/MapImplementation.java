package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Student;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative

public class MapImplementation implements ClassroomRepository 
{
	@Inject
	private JSONUtil util;
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Classroom> accountMap;
	private Long ID;

	
	
	public MapImplementation() 
	{
		this.accountMap = new HashMap<Long,Classroom>();
		ID = INITIAL_COUNT;
		
	}
	

	@Override
	public String getAllClassroom() {
		return util.getJSONForObject(accountMap.values());
	}

	@Override
	public String addClassroom (String account) { //
		ID++;
		Classroom newAccount = util.getObjectForJSON(account, Classroom.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	@Override
	public String updateClassroom(Long id, String accountToUpdate) {
		Classroom newAccount = util.getObjectForJSON(accountToUpdate, Classroom.class);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}

	@Override
	public String deleteClassroom(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	} 
	
	private void initAccountMap( ) 
	{
		
	}






}
	
	