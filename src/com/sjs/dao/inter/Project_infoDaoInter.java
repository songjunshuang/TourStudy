package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Project_info;

public interface Project_infoDaoInter {

	public List<Project_info> findAll() throws Exception;

	public Project_info findById(int id) throws Exception;

	public void doCreate(Project_info project_info) throws Exception;

	public void doUpdate(Project_info project_info) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
