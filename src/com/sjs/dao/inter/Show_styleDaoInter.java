package com.sjs.dao.inter;

import java.util.List;

import com.sjs.dao.vo.Show_style;

public interface Show_styleDaoInter {

	public List<Show_style> findAll() throws Exception;

	public Show_style findById(int id) throws Exception;

	public void doCreate(Show_style show_style) throws Exception;

	public void doUpdate(Show_style show_style) throws Exception;

	public void doDelete(int []delList) throws Exception;
	
}
