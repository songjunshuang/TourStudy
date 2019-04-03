package com.sjs.dao.vo;

import java.sql.Timestamp;

public class Show_style extends Person{
	
	int showId;
	Timestamp onlineDate;
	String showImage;
	String content;
	
	public Timestamp getOnlineDate() {
		return onlineDate;
	}
	
	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public void setOnlineDate(Timestamp onlineDate) {
		this.onlineDate = onlineDate;
	}
	
	public String getShowImage() {
		return showImage;
	}
	
	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
