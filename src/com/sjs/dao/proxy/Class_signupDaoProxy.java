package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Class_signup_DAOImpl;
import com.sjs.dao.inter.Class_signupDaoInter;
import com.sjs.dao.vo.Class_signup;
public class Class_signupDaoProxy implements Class_signupDaoInter{
	private DaoConn dbc=null;
	private Class_signupDaoInter dao=null;

	public Class_signupDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Class_signup_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Class_signup> findAll() throws Exception {
		List<Class_signup> all=null;
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
	public Class_signup findById(int id) throws Exception {
		Class_signup Class_signup=null;
		Class_signup=this.dao.findById(id);
		System.out.println(Class_signup.getName());
		return Class_signup;
	}

	@Override
	public void doCreate(Class_signup Class_signup) throws Exception {
		dao.doCreate(Class_signup);
	}

	@Override
	public void doUpdate(Class_signup Class_signup) throws Exception {
		dao.doUpdate(Class_signup);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
