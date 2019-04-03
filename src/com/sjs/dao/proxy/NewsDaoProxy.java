package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.News_DAOImpl;
import com.sjs.dao.inter.NewsDaoInter;
import com.sjs.dao.vo.News;

public class NewsDaoProxy implements NewsDaoInter{
	private DaoConn dbc=null;
	private NewsDaoInter dao=null;

	public NewsDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new News_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<News> findAll() throws Exception {
		List<News> all=null;
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
	public News findById(int id) throws Exception {
		News news=null;
		news=this.dao.findById(id);
		System.out.println(news.getNewsId());
		return news;
	}

	@Override
	public void doCreate(News news) throws Exception {
		dao.doCreate(news);
	}

	@Override
	public void doUpdate(News news) throws Exception {
		dao.doUpdate(news);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
