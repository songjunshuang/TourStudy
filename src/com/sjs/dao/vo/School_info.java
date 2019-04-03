package com.sjs.dao.vo;

public class School_info extends Person{
	
	int schoolId;
	String address;
	String name;
	
	public String getAddress() {
		return address;
	}
	
	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
