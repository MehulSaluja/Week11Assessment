package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Student;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)

public class ClassroomDBImplementation implements ClassroomRepository {

	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	
	public String getAllClassroom() 
	{
		Query query = manager.createQuery("Select a from Classroom a");
		Collection<Classroom> accounts = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Transactional(REQUIRED)
	public String addClassroom(String account) 
	{
		Classroom anAccount = util.getObjectForJSON(account, Classroom.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
		
	} 
	
	
	 
	@Transactional(REQUIRED)
	public String updateClassroom (Long id,String update_the_accounts) 
	{
		Classroom updatedAccount = util.getObjectForJSON(update_the_accounts, Classroom.class); //
		Classroom account_from_db = findClassroom(id);//
		if (update_the_accounts != null) 
		{
			account_from_db = updatedAccount;
			manager.merge(account_from_db);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom (Long id) 
	{
		Classroom account_in_db = findClassroom(id);
		if (account_in_db != null) 
		{
			manager.remove(account_in_db);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
		
	}
	
	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}
