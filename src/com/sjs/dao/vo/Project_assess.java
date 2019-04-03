package com.sjs.dao.vo;

import java.sql.Timestamp;

public class Project_assess {
	
	int assessId;
	int stuId;
	int projectId;
	Timestamp assessDate;
	int environment;
	int abtain;
	int development;
	int effect;
	int vivid;
	int association;
	String other;
	
	public int getAssessId() {
		return assessId;
	}

	public void setAssessId(int assessId) {
		this.assessId = assessId;
	}

	public int getStuId() {
		return stuId;
	}
	
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public Timestamp getAssessDate() {
		return assessDate;
	}
	
	public void setAssessDate(Timestamp assessDate) {
		this.assessDate = assessDate;
	}
	
	public int getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(int environment) {
		this.environment = environment;
	}
	
	public int getAbtain() {
		return abtain;
	}
	
	public void setAbtain(int abtain) {
		this.abtain = abtain;
	}
	
	public int getDevelopment() {
		return development;
	}
	
	public void setDevelopment(int development) {
		this.development = development;
	}
	
	public int getEffect() {
		return effect;
	}
	
	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public int getVivid() {
		return vivid;
	}
	
	public void setVivid(int vivid) {
		this.vivid = vivid;
	}
	
	public int getAssociation() {
		return association;
	}
	
	public void setAssociation(int association) {
		this.association = association;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}
	
}
