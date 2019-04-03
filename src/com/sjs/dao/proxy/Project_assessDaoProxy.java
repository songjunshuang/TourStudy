package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Project_assess_DAOImpl;
import com.sjs.dao.inter.Project_assessDaoInter;
import com.sjs.dao.vo.Project_assess;
public class Project_assessDaoProxy implements Project_assessDaoInter{
	private DaoConn dbc=null;
	private Project_assessDaoInter dao=null;

	public Project_assessDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Project_assess_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Project_assess> findAll() throws Exception {
		List<Project_assess> all=null;
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
	public Project_assess findById(int id) throws Exception {
		Project_assess project_assess=null;
		project_assess=this.dao.findById(id);
		System.out.println(project_assess.getStuId());
		return project_assess;
	}

	@Override
	public void doCreate(Project_assess project_assess) throws Exception {
		dao.doCreate(project_assess);
	}

	@Override
	public void doUpdate(Project_assess project_assess) throws Exception {
		dao.doUpdate(project_assess);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
