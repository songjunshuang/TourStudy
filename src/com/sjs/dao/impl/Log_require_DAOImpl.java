package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Log_requireDaoInter;
import com.sjs.dao.vo.Log_require;

public class Log_require_DAOImpl implements Log_requireDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Log_require_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Log_require> findAll() throws Exception {
			List<Log_require> all=new ArrayList<Log_require>();
			String sql="select * from log_require";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Log_require log_require=null;
			while(rs.next()){
				log_require = new Log_require();
				log_require.setLogRequireId(rs.getInt("logRequireId"));
				log_require.setGroupOrderId(rs.getInt("groupOrderId"));
				log_require.setContent(rs.getString("content"));
				log_require.setNumberCount(rs.getInt("numberCount"));
				log_require.setRequireTime(rs.getTimestamp("requireTime"));
				all.add(log_require);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Log_require findById(int id) throws Exception {
			Log_require log_require=null;

			String sql="select * from log_require where logRequireId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				log_require = new Log_require();
				log_require.setLogRequireId(rs.getInt("logRequireId"));
				log_require.setGroupOrderId(rs.getInt("groupOrderId"));
				log_require.setContent(rs.getString("content"));
				log_require.setNumberCount(rs.getInt("numberCount"));
				log_require.setRequireTime(rs.getTimestamp("requireTime"));
			}
			pstmt.close();
			return log_require;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Log_require log_require) throws Exception {
			DaoConn.calcMaxId("log_require","logRequireId",conn);
			String sql="insert into log_require (groupOrderId,content,numberCount,requireTime) values(?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,log_require.getGroupOrderId());
			this.pstmt.setString(2,log_require.getContent());
			this.pstmt.setInt(3,log_require.getNumberCount());
			this.pstmt.setTimestamp(4,log_require.getRequireTime());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(log_require.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Log_require log_require) throws Exception {
			String sql="update log_require set groupOrderId=? ,content=? ,numberCount=? ,requireTime=? where logRequireId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,log_require.getGroupOrderId());
			this.pstmt.setString(2,log_require.getContent());
			this.pstmt.setInt(3,log_require.getNumberCount());
			this.pstmt.setTimestamp(4,log_require.getRequireTime());
			this.pstmt.setInt(5,log_require.getLogRequireId());
			this.pstmt.executeUpdate();
			pstmt.close();			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from log_require where logRequireId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
