package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Project_assess;

public interface Project_assessDaoInter {

	public List<Project_assess> findAll() throws Exception;

	public Project_assess findById(int id) throws Exception;

	public void doCreate(Project_assess project_assess) throws Exception;

	public void doUpdate(Project_assess project_assess) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
