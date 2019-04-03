package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Log_info;

public interface Log_infoDaoInter {

	public List<Log_info> findAll() throws Exception;

	public Log_info findById(int id) throws Exception;

	public void doCreate(Log_info log_info) throws Exception;

	public void doUpdate(Log_info log_info) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
