package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Log_require;

public interface Log_requireDaoInter {

	public List<Log_require> findAll() throws Exception;

	public Log_require findById(int id) throws Exception;

	public void doCreate(Log_require homework_require) throws Exception;

	public void doUpdate(Log_require homework_require) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
