package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Project_infoDaoInter;
import com.sjs.dao.vo.Project_info;

public class Project_info_DAOImpl implements Project_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Project_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Project_info> findAll() throws Exception {
			List<Project_info> all=new ArrayList<Project_info>();
			String sql="select * from project_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Project_info project_info=null;
			while(rs.next()){
				project_info = new Project_info();
				project_info.setProjectId(rs.getInt("projectId"));
				project_info.setName(rs.getString("name"));
				project_info.setTypeId(rs.getInt("typeId"));
				project_info.setIntroduce(rs.getString("introduce"));
				project_info.setProjectImage(rs.getString("projectImage"));
				project_info.setPrice(rs.getFloat("price"));
				all.add(project_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Project_info findById(int id) throws Exception {
			Project_info project_info=null;

			String sql="select * from project_info where projectId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				project_info = new Project_info();
				project_info.setProjectId(rs.getInt("projectId"));
				project_info.setName(rs.getString("name"));
				project_info.setTypeId(rs.getInt("typeId"));
				project_info.setIntroduce(rs.getString("introduce"));
				project_info.setProjectImage(rs.getString("projectImage"));
				project_info.setPrice(rs.getFloat("price"));
			}
			pstmt.close();
			return project_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Project_info project_info) throws Exception {
			DaoConn.calcMaxId("project_info","projectId",conn);
			String sql="insert into project_info (name,typeId,introduce,projectImage,price) values(?,?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,project_info.getName());
			this.pstmt.setInt(2,project_info.getTypeId());
			this.pstmt.setString(3,project_info.getIntroduce());
			this.pstmt.setString(4,project_info.getProjectImage());
			this.pstmt.setFloat(5,project_info.getPrice());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(project_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Project_info project_info) throws Exception {
			String sql="update project_info set name=? ,typeId=? ,introduce=?,projectImage=? ,price=? where projectId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,project_info.getName());
			this.pstmt.setInt(2,project_info.getTypeId());
			this.pstmt.setString(3,project_info.getIntroduce());
			this.pstmt.setString(4,project_info.getProjectImage());
			this.pstmt.setFloat(5,project_info.getPrice());
			this.pstmt.setFloat(6,project_info.getProjectId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from project_info where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
