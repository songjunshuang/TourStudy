package com.sjs.dao.vo;

public class Project_info {
	
	int projectId;
	String name;
	int typeId;
	String introduce;
	String projectImage;
	float price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getProjectImage() {
		return projectImage;
	}
	
	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
}
