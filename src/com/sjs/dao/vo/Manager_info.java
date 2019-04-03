package com.sjs.dao.vo;

public class Manager_info extends Person{
	
	int managerId;
	Person person;

	public Person getPerson() {
		return person;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
