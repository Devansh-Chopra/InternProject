package com.devansh.springboot.model;

import jakarta.persistence.*;
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
	private String name;

	@Autowired
	@OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
	public List<Intern> internsAssociated=new ArrayList<>();


	public Mentor(){

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