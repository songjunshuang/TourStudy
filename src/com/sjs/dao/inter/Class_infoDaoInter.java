package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Class_info;

public interface Class_infoDaoInter {

	public List<Class_info> findAll() throws Exception;

	public Class_info findById(int id) throws Exception;

	public void doCreate(Class_info class_info) throws Exception;

	public void doUpdate(Class_info class_info) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
