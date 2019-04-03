package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Teacher_info_DAOImpl;
import com.sjs.dao.inter.Teacher_infoDaoInter;
import com.sjs.dao.vo.Teacher_info;
public class Teacher_infoDaoProxy implements Teacher_infoDaoInter{
	private DaoConn dbc=null;
	private Teacher_infoDaoInter dao=null;

	public Teacher_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Teacher_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Teacher_info> findAll() throws Exception {
		List<Teacher_info> all=null;
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
	public Teacher_info findById(int id) throws Exception {
		Teacher_info teacher_infoDao=null;
		teacher_infoDao=this.dao.findById(id);
		return teacher_infoDao;
	}

	@Override
	public void doCreate(Teacher_info teacher_infoDao) throws Exception {
		dao.doCreate(teacher_infoDao);
	}

	@Override
	public void doUpdate(Teacher_info teacher_infoDao) throws Exception {
		dao.doUpdate(teacher_infoDao);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}

	@Override
	public Teacher_info findByLoginName(String loginName) throws Exception {
		Teacher_info teacher_info=null;
		teacher_info=this.dao.findByLoginName(loginName);
		System.out.println(teacher_info.getPerson().getLoginName());
		return teacher_info;
	}
}
