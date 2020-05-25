package com.kubicodes.springboot.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Exam {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Size(max = 20, message = "Nur 15 Zeichen erlaubt!")
	private String category;
	
	private Date examDate;
	private boolean isPassed;
	
	
	//Constructors
	
	public Exam() {
		super();
	}
	
	public Exam(int id, String name, String description, Date examDate,
			boolean isPassed) {
		this.id = id;
		this.name = name;
		this.category = description;
		this.examDate = examDate;
		this.isPassed = isPassed;
	}

	
	//Getters and Setters
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public boolean getIsPassed() {
		return isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	
	
	//Hashcode and Equals Method
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	//toString
		@Override
		public String toString() {
			return "Exam [id=" + id + ", name=" + name + ""
					+ ", description=" + category + ", examDate=" + examDate
					+ ", isPassed=" + isPassed + "]";
		}


	
	
	
	
}
