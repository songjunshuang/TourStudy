package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Manager_info_DAOImpl;
import com.sjs.dao.inter.Manager_infoDaoInter;
import com.sjs.dao.vo.Manager_info;
public class Manager_infoDaoProxy implements Manager_infoDaoInter{
	private DaoConn dbc=null;
	private Manager_infoDaoInter dao=null;

	public Manager_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Manager_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Manager_info> findAll() throws Exception {
		List<Manager_info> all=null;
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
	public Manager_info findById(int id) throws Exception {
		Manager_info manager_info=null;
		manager_info=this.dao.findById(id);
		System.out.println(manager_info.getName());
		return manager_info;
	}

	@Override
	public void doCreate(Manager_info manager_info) throws Exception {
		dao.doCreate(manager_info);
	}

	@Override
	public void doUpdate(Manager_info manager_info) throws Exception {
		dao.doUpdate(manager_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
	
	@Override
	public Manager_info findByLoginName(String loginName) throws Exception {
		Manager_info manager_info=null;
		manager_info=this.dao.findByLoginName(loginName);
		System.out.println(manager_info.getPerson().getLoginName());
		return manager_info;
	}
}
