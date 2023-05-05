package com.example.demo.controller.models;

import org.springframework.stereotype.Controller;


public class Person {
// person properties
	private int id;
	private String FirstName;
	private String LastName;
	private int age;
	private float Salary;
	private String Job;
	private float weight;
	
	
	public Person() {
		super();
	}
	public Person(int id, String firstName, String lastName, int age, float salary, String job, float weight) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.age = age;
		Salary = salary;
		Job = job;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", age=" + age + ", Salary="
				+ Salary + ", Job=" + Job + ", weight=" + weight + "]";
	}
	
	
	
	
	

}