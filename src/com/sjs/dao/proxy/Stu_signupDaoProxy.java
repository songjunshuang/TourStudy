package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Stu_signup_DAOImpl;
import com.sjs.dao.inter.Stu_signupDaoInter;
import com.sjs.dao.vo.Stu_signup;
public class Stu_signupDaoProxy implements Stu_signupDaoInter{
	private DaoConn dbc=null;
	private Stu_signupDaoInter dao=null;

	public Stu_signupDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Stu_signup_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Stu_signup> findAll() throws Exception {
		List<Stu_signup> all=null;
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
	public Stu_signup findById(int id) throws Exception {
		Stu_signup stu_signup=null;
		stu_signup=this.dao.findById(id);
		System.out.println(stu_signup.getGroupOrderId());
		return stu_signup;
	}

	@Override
	public void doCreate(Stu_signup stu_signup) throws Exception {
		dao.doCreate(stu_signup);
	}

	@Override
	public void doUpdate(Stu_signup stu_signup) throws Exception {
		dao.doUpdate(stu_signup);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
