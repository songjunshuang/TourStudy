package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Teacher_favorite_DAOImpl;
import com.sjs.dao.inter.Teacher_favoriteDaoInter;
import com.sjs.dao.vo.Teacher_favorite;
public class Teacher_favoriteDaoProxy implements Teacher_favoriteDaoInter{
	private DaoConn dbc=null;
	private Teacher_favoriteDaoInter dao=null;

	public Teacher_favoriteDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Teacher_favorite_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Teacher_favorite> findAll() throws Exception {
		List<Teacher_favorite> all=null;
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
	public Teacher_favorite findById(int id) throws Exception {
		Teacher_favorite teacher_favorite=null;
		teacher_favorite=this.dao.findById(id);
		System.out.println(teacher_favorite.getFavoriteId());
		return teacher_favorite;
	}

	@Override
	public void doCreate(Teacher_favorite teacher_favorite) throws Exception {
		dao.doCreate(teacher_favorite);
	}

	@Override
	public void doUpdate(Teacher_favorite teacher_favorite) throws Exception {
		dao.doUpdate(teacher_favorite);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
