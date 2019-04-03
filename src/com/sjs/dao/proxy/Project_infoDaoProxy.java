package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Project_info_DAOImpl;
import com.sjs.dao.inter.Project_infoDaoInter;
import com.sjs.dao.vo.Project_info;
public class Project_infoDaoProxy implements Project_infoDaoInter{
	private DaoConn dbc=null;
	private Project_infoDaoInter dao=null;

	public Project_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Project_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Project_info> findAll() throws Exception {
		List<Project_info> all=null;
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
	public Project_info findById(int id) throws Exception {
		Project_info project_info=null;
		project_info=this.dao.findById(id);
		System.out.println(project_info.getName());
		return project_info;
	}

	@Override
	public void doCreate(Project_info project_info) throws Exception {
		dao.doCreate(project_info);
	}

	@Override
	public void doUpdate(Project_info project_info) throws Exception {
		dao.doUpdate(project_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
