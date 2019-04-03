package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Log_info_DAOImpl;
import com.sjs.dao.inter.Log_infoDaoInter;
import com.sjs.dao.vo.Log_info;
public class Log_infoDaoProxy implements Log_infoDaoInter{
	private DaoConn dbc=null;
	private Log_infoDaoInter dao=null;

	public Log_infoDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Log_info_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Log_info> findAll() throws Exception {
		List<Log_info> all=null;
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
	public Log_info findById(int id) throws Exception {
		Log_info log_info=null;
		log_info=this.dao.findById(id);
		System.out.println(log_info.getName());
		return log_info;
	}

	@Override
	public void doCreate(Log_info log_info) throws Exception {
		dao.doCreate(log_info);
	}

	@Override
	public void doUpdate(Log_info log_info) throws Exception {
		dao.doUpdate(log_info);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
