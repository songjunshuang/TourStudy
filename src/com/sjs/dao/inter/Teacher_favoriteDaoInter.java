package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Teacher_favorite;

public interface Teacher_favoriteDaoInter {

	public List<Teacher_favorite> findAll() throws Exception;

	public Teacher_favorite findById(int id) throws Exception;

	public void doCreate(Teacher_favorite teacher_favorite) throws Exception;

	public void doUpdate(Teacher_favorite teacher_favorite) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
