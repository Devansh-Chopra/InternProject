package com.devansh.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "Course's name cannot be blank")
	private String name;


	@JsonIgnore
	@ManyToMany(mappedBy = "assignedCourses",cascade = CascadeType.ALL)
	List<Intern> internsAssociated=new ArrayList<>();

	@JsonProperty("internsAssociated")
	List<String> getInternsAssociatedNames(){
		return this.internsAssociated.stream().map(intern -> intern.getFirstName()).toList();
	}

	@Override
	public String toString() {
		return name;
	}

	// Needed by Caused by: com.fasterxml.jackson.databind.JsonMappingException:
	// Can not construct instance of com.in28minutes.springboot.model.Course:
	// no suitable constructor found, can not deserialize from Object value
	// (missing default constructor or creator, or perhaps need to add/enable
	// type information?)
	public Course() {

	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}




}