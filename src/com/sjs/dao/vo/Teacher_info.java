package com.sjs.dao.vo;

public class Teacher_info extends Person{
	
	
	int teacherId;
	Person person;
	int isheadTeacher;
	String photo;
	int classId;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getIsheadTeacher() {
		return isheadTeacher;
	}

	public void setIsheadTeacher(int isheadTeacher) {
		this.isheadTeacher = isheadTeacher;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
