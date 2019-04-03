package com.sjs.dao.vo;

import java.sql.Timestamp;

public class Log_info extends Person{
	
	int logId;
	int stuId;
	Timestamp uploadDate;
	String content;
	
	public int getStuId() {
		return stuId;
	}
	
	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
