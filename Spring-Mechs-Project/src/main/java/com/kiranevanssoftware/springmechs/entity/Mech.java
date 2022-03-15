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
	@Min(2)
	@Max(20)
	private int yearManufactured;


	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private String model;
	
	@Column
	private int weight;
	
	//Default constructor
	public Mech() {}


	public Mech(@Min(2) @Max(20) int yearManufactured, String name, String model, int weight) {
		super();
		this.yearManufactured = yearManufactured;
		this.name = name;
		this.model = model;
		this.weight = weight;
	}
	
	//For testing
	public Mech(long id, @Min(2) @Max(20) int yearManufactured, String name, String model, int weight) {
		super();
		this.id = id;
		this.yearManufactured = yearManufactured;
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

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
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
		return "Mech [id=" + id + ", yearManufactured=" + yearManufactured + ", name=" + name + ", model=" + model + ", weight=" + weight
				+ "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(yearManufactured, weight, model, name);
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
		return yearManufactured == other.yearManufactured && Objects.equals(weight, other.weight) && Objects.equals(model, other.model)
				&& Objects.equals(name, other.name);
	}
}
