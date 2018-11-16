package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Classroom {
	 @GeneratedValue (strategy=GenerationType.AUTO)
	 @Id
	
	private Long classroom_id;
	@Column (length = 100)
	private String name_of_trainer;
	
	
	
	@OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn()
	
	private List<Student> studentList;
	
	
	
	public Classroom (Long id, String trainer_name) 
	{
		super();
		this.classroom_id =  id;
		this.name_of_trainer = trainer_name;
		
		
		
	}
	
	public Long getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(Long classroom_id) {
		this.classroom_id = classroom_id;
	}

	public String getName_of_trainer() {
		return name_of_trainer;
	}

	public void setName_of_trainer(String name_of_trainer) {
		this.name_of_trainer = name_of_trainer;
	}

	public Classroom ()
	{
		
	}

	@Override
	public String toString() {
		return "Classroom [classroom_id=" + classroom_id + ", name_of_trainer=" + name_of_trainer + "]";
	}
	
	
	

}
