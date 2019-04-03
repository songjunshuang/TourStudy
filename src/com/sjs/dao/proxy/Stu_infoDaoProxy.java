package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Stu_info_DAOImpl;
import com.sjs.dao.inter.Stu_infoDaoInter;
import com.sjs.dao.vo.Stu_info;
public class Stu_infoDaoProxy implements Stu_infoDaoInter{
	private DaoConn dbc=null;
	private Stu_infoDaoInter dao=null;

	public Stu_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Stu_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Stu_info> findAll() throws Exception {
		List<Stu_info> all=null;
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
	public Stu_info findById(int id) throws Exception {
		Stu_info stu_info=null;
		stu_info=this.dao.findById(id);
		System.out.println(stu_info.getPerson().getName());
		return stu_info;
	}

	@Override
	public void doCreate(Stu_info stu_info) throws Exception {
		dao.doCreate(stu_info);
	}

	@Override
	public void doUpdate(Stu_info stu_info) throws Exception {
		dao.doUpdate(stu_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}

	@Override
	public Stu_info findByLoginName(String loginName) throws Exception {
		Stu_info stu_info=null;
		stu_info=this.dao.findByLoginName(loginName);
		System.out.println(stu_info.getPerson().getLoginName());
		return stu_info;
	}
}
