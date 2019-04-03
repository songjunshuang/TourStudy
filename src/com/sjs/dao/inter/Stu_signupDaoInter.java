package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Stu_signup;

public interface Stu_signupDaoInter {

	public List<Stu_signup> findAll() throws Exception;

	public Stu_signup findById(int id) throws Exception;

	public void doCreate(Stu_signup stu_signup) throws Exception;

	public void doUpdate(Stu_signup stu_signup) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
