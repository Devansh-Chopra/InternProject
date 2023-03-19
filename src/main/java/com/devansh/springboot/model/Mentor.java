package com.devansh.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Mentor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotBlank(message = "Mentor's name cannot be blank")
	private String name;

	@JsonIgnore
	@Autowired
	@OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
	public List<Intern> internsAssociated=new ArrayList<>();


	public Mentor(){

	}

	@JsonProperty("associatedInterns")
	public List<String> getAssociatedInternsNames(){
		return this.getInternsAssociated().stream().map(intern -> intern.getFirstName()).toList();
	}
	@Override
	public String toString() {
		return name;
	}
	public Mentor(String name) {
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

	public void setName(String name) {
		this.name = name;
	}

	public List<Intern> getInternsAssociated() {
		return internsAssociated;
	}

	public void setInternsAssociated(List<Intern> internsAssociated) {
		internsAssociated = internsAssociated;
	}
}