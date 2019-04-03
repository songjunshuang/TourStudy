package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Stu_info;

public interface Stu_infoDaoInter {

	public List<Stu_info> findAll() throws Exception;

	public Stu_info findById(int id) throws Exception;

	public void doCreate(Stu_info stu_info) throws Exception;

	public void doUpdate(Stu_info stu_info) throws Exception;

	public void doDelete(int []delList) throws Exception;

	public Stu_info findByLoginName(String loginName) throws Exception;
	
}
