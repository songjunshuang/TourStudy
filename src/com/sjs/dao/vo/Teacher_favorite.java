package com.sjs.dao.vo;

import java.sql.Timestamp;

public class Teacher_favorite {
	
	int favoriteId;
	int projectId;
	int teacherId;
	Timestamp collecTime;
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public Timestamp getCollecTime() {
		return collecTime;
	}
	
	public void setCollecTime(Timestamp collecTime) {
		this.collecTime = collecTime;
	}
		
}
