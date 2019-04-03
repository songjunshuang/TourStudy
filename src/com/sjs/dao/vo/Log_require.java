package com.sjs.dao.vo;

import java.sql.Timestamp;

public class Log_require{
	
	int logRequireId;
	int groupOrderId;
	String content;
	int numberCount;
	Timestamp requireTime;
	
	public int getGroupOrderId() {
		return groupOrderId;
	}
	
	public int getLogRequireId() {
		return logRequireId;
	}

	public void setLogRequireId(int logRequireId) {
		this.logRequireId = logRequireId;
	}

	public void setGroupOrderId(int groupOrderId) {
		this.groupOrderId = groupOrderId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getNumberCount() {
		return numberCount;
	}
	
	public void setNumberCount(int numberCount) {
		this.numberCount = numberCount;
	}
	
	public Timestamp getRequireTime() {
		return requireTime;
	}
	
	public void setRequireTime(Timestamp requireTime) {
		this.requireTime = requireTime;
	}
		
}
