package com.qa.business.service;

public interface AccountService 
{
	String getAllClassroom();

	String addClassroom(String account);

	String updateClassroom(Long id, String account);

	String deleteClassroom(Long id);


}
