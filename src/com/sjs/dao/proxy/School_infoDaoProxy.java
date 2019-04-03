package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.School_info_DAOImpl;
import com.sjs.dao.inter.School_infoDaoInter;
import com.sjs.dao.vo.School_info;
public class School_infoDaoProxy implements School_infoDaoInter{
	private DaoConn dbc=null;
	private School_infoDaoInter dao=null;

	public School_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new School_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<School_info> findAll() throws Exception {
		List<School_info> all=null;
		try{
			all=this.dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return  all;
	}

	@Override
	public School_info findById(int id) throws Exception {
		School_info school_info=null;
		school_info=this.dao.findById(id);
		System.out.println(school_info.getName());
		return school_info;
	}

	@Override
	public void doCreate(School_info school_info) throws Exception {
		dao.doCreate(school_info);
	}

	@Override
	public void doUpdate(School_info school_info) throws Exception {
		dao.doUpdate(school_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
