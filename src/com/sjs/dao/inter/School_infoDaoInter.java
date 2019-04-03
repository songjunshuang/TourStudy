package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.School_info;

public interface School_infoDaoInter {

	public List<School_info> findAll() throws Exception;

	public School_info findById(int id) throws Exception;

	public void doCreate(School_info school_info) throws Exception;

	public void doUpdate(School_info school_info) throws Exception;

	public void doDelete(int []delList) throws Exception;

}
