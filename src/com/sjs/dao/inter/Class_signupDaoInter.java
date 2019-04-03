package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Class_signup;

public interface Class_signupDaoInter {

	public List<Class_signup> findAll() throws Exception;

	public Class_signup findById(int id) throws Exception;

	public void doCreate(Class_signup class_signup) throws Exception;

	public void doUpdate(Class_signup class_signup) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
