package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Teacher_info;

public interface Teacher_infoDaoInter {

	public List<Teacher_info> findAll() throws Exception;

	public Teacher_info findById(int id) throws Exception;

	public void doCreate(Teacher_info teacher_info) throws Exception;

	public void doUpdate(Teacher_info teacher_info) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
	public Teacher_info findByLoginName(String loginName) throws Exception;
}
