package com.sjs.dao.inter;

import java.util.List;
import com.sjs.dao.vo.Manager_info;

public interface Manager_infoDaoInter {

	public List<Manager_info> findAll() throws Exception;

	public Manager_info findById(int id) throws Exception;

	public void doCreate(Manager_info class_info) throws Exception;

	public void doUpdate(Manager_info class_info) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
	public Manager_info findByLoginName(String loginName) throws Exception;
}
