package com.qa.persistence.repository;

public interface ClassroomRepository {
	String getAllClassroom();

	String updateClassroom(Long id, String accountToUpdate);

	String deleteClassroom(Long id);

	String addClassroom(String account);

}
