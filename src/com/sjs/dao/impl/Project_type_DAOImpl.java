package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Project_typeDaoInter;
import com.sjs.dao.vo.Project_type;

public class Project_type_DAOImpl implements Project_typeDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Project_type_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Project_type> findAll() throws Exception {
			List<Project_type> all=new ArrayList<Project_type>();
			String sql="select * from project_type";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Project_type project_type=null;
			while(rs.next()){
				project_type = new Project_type();
				project_type.setTypeId(rs.getInt("typeId"));
				project_type.setName(rs.getString("name"));
				all.add(project_type);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Project_type findById(int id) throws Exception {
			Project_type project_type=null;

			String sql="select * from project_type where typeId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				project_type = new Project_type();
				project_type.setTypeId(rs.getInt("typeId"));
				project_type.setName(rs.getString("name"));
			}
			pstmt.close();
			return project_type;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Project_type project_type) throws Exception {
			DaoConn.calcMaxId("project_type","typeId",conn);
			String sql="insert into project_type (name) values(?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,project_type.getName());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(project_type.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Project_type project_type) throws Exception {
			String sql="update project_type set name=? where typeId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,project_type.getName());
			this.pstmt.setInt(2,project_type.getTypeId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from project_type where typeId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
