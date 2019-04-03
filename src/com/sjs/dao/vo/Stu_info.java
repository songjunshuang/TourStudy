package com.sjs.dao.vo;

public class Stu_info extends Person{
	
	Person person;
	int stuId;
	int classId;
	String parentTel;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getParentTel() {
		return parentTel;
	}

	public void setParentTel(String parentTel) {
		this.parentTel = parentTel;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

}
