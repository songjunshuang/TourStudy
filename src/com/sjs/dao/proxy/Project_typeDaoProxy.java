package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Project_type_DAOImpl;
import com.sjs.dao.inter.Project_typeDaoInter;
import com.sjs.dao.vo.Project_type;
public class Project_typeDaoProxy implements Project_typeDaoInter{
	private DaoConn dbc=null;
	private Project_typeDaoInter dao=null;

	public Project_typeDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Project_type_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Project_type> findAll() throws Exception {
		List<Project_type> all=null;
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
	public Project_type findById(int id) throws Exception {
		Project_type project_type=null;
		project_type=this.dao.findById(id);
		System.out.println(project_type.getName());
		return project_type;
	}

	@Override
	public void doCreate(Project_type project_type) throws Exception {
		dao.doCreate(project_type);
	}

	@Override
	public void doUpdate(Project_type project_type) throws Exception {
		dao.doUpdate(project_type);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
