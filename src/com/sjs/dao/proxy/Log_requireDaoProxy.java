package com.sjs.dao.proxy;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.impl.Log_require_DAOImpl;
import com.sjs.dao.inter.Log_requireDaoInter;
import com.sjs.dao.vo.Log_require;
public class Log_requireDaoProxy implements Log_requireDaoInter{
	private DaoConn dbc=null;
	private Log_requireDaoInter dao=null;

	public Log_requireDaoProxy() {
		try {
			this.dbc = new DaoConn();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		this.dao = new Log_require_DAOImpl(this.dbc.getConn());
	}

	@Override
	public List<Log_require> findAll() throws Exception {
		List<Log_require> all=null;
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
	public Log_require findById(int id) throws Exception {
		Log_require log_require=null;
		log_require=this.dao.findById(id);
		System.out.println(log_require.getGroupOrderId());
		return log_require;
	}

	@Override
	public void doCreate(Log_require log_require) throws Exception {
		dao.doCreate(log_require);
	}

	@Override
	public void doUpdate(Log_require log_require) throws Exception {
		dao.doUpdate(log_require);
	}

	@Override
	public void doDelete(int[] delList) throws Exception {
		dao.doDelete(delList);
	}
}
