package com.kiranevanssoftware.springmechs.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Mech {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Min(2000)
	@Max(3000)
	private int year;


	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private String model;
	
	@Column
	private int weight;
	
	//Default constructor
	public Mech() {}


	public Mech(@Min(2000) @Max(3000) int year, String name, String model, int weight) {
		super();
		this.year = year;
		this.name = name;
		this.model = model;
		this.weight = weight;
	}
	
	//For testing
	public Mech(long id, @Min(2000) @Max(3000) int year, String name, String model, int weight) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.model = model;
		this.weight = weight;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mech [id=" + id + ", year=" + year + ", name=" + name + ", model=" + model + ", weight=" + weight
				+ "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(year, weight, model, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Mech other = (Mech) obj;
		return year == other.year && Objects.equals(weight, other.weight) && Objects.equals(model, other.model)
				&& Objects.equals(name, other.name);
	}
}
