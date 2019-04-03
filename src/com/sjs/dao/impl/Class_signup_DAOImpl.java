package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Class_signupDaoInter;
import com.sjs.dao.vo.Class_signup;

public class Class_signup_DAOImpl implements Class_signupDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Class_signup_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Class_signup> findAll() throws Exception {
			List<Class_signup> all=new ArrayList<Class_signup>();
			String sql="select * from class_signup";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Class_signup class_signup=null;
			while(rs.next()){
				class_signup = new Class_signup();
				class_signup.setGroupOrderId(rs.getInt("groupOrderId"));
				class_signup.setName(rs.getString("name"));
				class_signup.setClassId(rs.getInt("classId"));
				class_signup.setProjectId(rs.getInt("projectId"));
				all.add(class_signup);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Class_signup findById(int id) throws Exception {
			Class_signup class_signup=null;

			String sql="select * from class_signup where groupOrderId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				class_signup = new Class_signup();
				class_signup.setGroupOrderId(rs.getInt("groupOrderId"));
				class_signup.setName(rs.getString("name"));
				class_signup.setClassId(rs.getInt("classId"));
				class_signup.setProjectId(rs.getInt("projectId"));
			}
			pstmt.close();
			return class_signup;
		}
		
		/**
		 * 创建对象，向表中加入一条记录
		 * */
		@Override	
		public void doCreate(Class_signup class_signup) throws Exception {
			DaoConn.calcMaxId("class_signup","groupOrderId",conn);
			String sql="insert into class_signup (name,projectId,classId) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,class_signup.getName());
			this.pstmt.setInt(2,class_signup.getProjectId());
			this.pstmt.setInt(3,class_signup.getClassId());

//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(Class_signup.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Class_signup class_signup) throws Exception {
			String sql="update class_signup set name=? ,projectId=? ,classId=? where groupOrderId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,class_signup.getName());
			this.pstmt.setInt(2,class_signup.getProjectId());

			this.pstmt.setInt(3,class_signup.getClassId());
			this.pstmt.setInt(4,class_signup.getGroupOrderId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from class_signup where groupOrderId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
