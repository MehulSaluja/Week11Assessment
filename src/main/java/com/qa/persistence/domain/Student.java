package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Student 
{
	 @GeneratedValue (strategy=GenerationType.AUTO)
	 @Id
	
	private Long student_id;
	@Column (length = 100)
	private String name_of_student;
	
	//@Column
	//private int room_number_student_should_be_in;
	
	public Student (Long id, String name_of_student) 
	{
		super();
		this.student_id =  id;
		this.name_of_student = name_of_student;
		
		
	
	}
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name_of_student=" + name_of_student + "]";
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getName_of_student() {
		return name_of_student;
	}

	public void setName_of_student(String name_of_student) {
		this.name_of_student = name_of_student;
	}

	public Student ()
	{
		
	}
	

	

	
	
	
	
	
	

}

