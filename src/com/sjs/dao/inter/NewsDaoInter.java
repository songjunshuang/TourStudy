package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.News;

public interface NewsDaoInter {

	public List<News> findAll() throws Exception;

	public News findById(int id) throws Exception;

	public void doCreate(News news) throws Exception;

	public void doUpdate(News news) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
