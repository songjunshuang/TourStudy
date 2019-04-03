package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Show_style_DAOImpl;
import com.sjs.dao.inter.Show_styleDaoInter;
import com.sjs.dao.vo.Show_style;
public class Show_styleDaoProxy implements Show_styleDaoInter{
	private DaoConn dbc=null;
	private Show_styleDaoInter dao=null;

	public Show_styleDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Show_style_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Show_style> findAll() throws Exception {
		List<Show_style> all=null;
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
	public Show_style findById(int id) throws Exception {
		Show_style show_style=null;
		show_style=this.dao.findById(id);
		System.out.println(show_style.getName());
		return show_style;
	}

	@Override
	public void doCreate(Show_style show_style) throws Exception {
		dao.doCreate(show_style);
	}

	@Override
	public void doUpdate(Show_style show_style) throws Exception {
		dao.doUpdate(show_style);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
