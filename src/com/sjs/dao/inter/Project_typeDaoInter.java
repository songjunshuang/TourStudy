package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Project_type;

public interface Project_typeDaoInter {

	public List<Project_type> findAll() throws Exception;

	public Project_type findById(int id) throws Exception;

	public void doCreate(Project_type project_type) throws Exception;

	public void doUpdate(Project_type project_type) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
