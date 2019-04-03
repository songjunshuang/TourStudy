package com.sjs.dao.vo;

import java.sql.Timestamp;

public class News {
	
	int newsId;
	Timestamp happenDate;
	Timestamp onlineDate;
	String content;
	
	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public Timestamp getHappenDate() {
		return happenDate;
	}
	
	public void setHappenDate(Timestamp happenDate) {
		this.happenDate = happenDate;
	}
	
	public Timestamp getOnlineDate() {
		return onlineDate;
	}
	
	public void setOnlineDate(Timestamp onlineDate) {
		this.onlineDate = onlineDate;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
