package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Log_infoDaoInter;
import com.sjs.dao.vo.Log_info;

public class Log_info_DAOImpl implements Log_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Log_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Log_info> findAll() throws Exception {
			List<Log_info> all=new ArrayList<Log_info>();
			String sql="select * from log_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Log_info log_info=null;
			while(rs.next()){
				log_info = new Log_info();
				log_info.setLogId(rs.getInt("logId"));
				log_info.setStuId(rs.getInt("stuId"));
				log_info.setUploadDate(rs.getTimestamp("uploadDate"));
				log_info.setContent(rs.getString("content"));
				all.add(log_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Log_info findById(int id) throws Exception {
			Log_info log_info=null;

			String sql="select * from log_info where logId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				log_info = new Log_info();
				log_info.setLogId(rs.getInt("logId"));
				log_info.setStuId(rs.getInt("stuId"));
				log_info.setUploadDate(rs.getTimestamp("uploadDate"));
				log_info.setContent(rs.getString("content"));
			}
			pstmt.close();
			return log_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Log_info log_info) throws Exception {
			DaoConn.calcMaxId("log_info","logId",conn);
			String sql="insert into log_info (stuId,uploadDate,content) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,log_info.getStuId());
			this.pstmt.setTimestamp(2,log_info.getUploadDate());
			this.pstmt.setString(3,log_info.getContent());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(log_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Log_info log_info) throws Exception {
			String sql="update log_info set stuId=? ,uploadDate=? ,content=? where logId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,log_info.getStuId());
			this.pstmt.setTimestamp(2,log_info.getUploadDate());
			this.pstmt.setString(3,log_info.getContent());
			this.pstmt.setInt(4,log_info.getLogId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from log_info where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
