package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Class_info_DAOImpl;
import com.sjs.dao.inter.Class_infoDaoInter;
import com.sjs.dao.vo.Class_info;
public class Class_infoDaoProxy implements Class_infoDaoInter{
	private DaoConn dbc=null;
	private Class_infoDaoInter dao=null;

	public Class_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Class_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Class_info> findAll() throws Exception {
		List<Class_info> all=null;
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
	public Class_info findById(int id) throws Exception {
		Class_info class_info=null;
		class_info=this.dao.findById(id);
		System.out.println(class_info.getName());
		return class_info;
	}

	@Override
	public void doCreate(Class_info class_info) throws Exception {
		dao.doCreate(class_info);
	}

	@Override
	public void doUpdate(Class_info class_info) throws Exception {
		dao.doUpdate(class_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
