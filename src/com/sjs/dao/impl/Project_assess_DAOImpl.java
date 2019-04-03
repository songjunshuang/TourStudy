package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Project_assessDaoInter;
import com.sjs.dao.vo.Project_assess;

public class Project_assess_DAOImpl implements Project_assessDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Project_assess_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Project_assess> findAll() throws Exception {
			List<Project_assess> all=new ArrayList<Project_assess>();
			String sql="select * from project_assess";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Project_assess project_assess=null;
			while(rs.next()){
				project_assess = new Project_assess();
				project_assess.setAssessId(rs.getInt("assessId"));
				project_assess.setStuId(rs.getInt("stuId"));
				project_assess.setProjectId(rs.getInt("projectId"));
				project_assess.setAssessDate(rs.getTimestamp("assessDate"));
				project_assess.setEnvironment(rs.getInt("environment"));
				project_assess.setAbtain(rs.getInt("abtain"));
				project_assess.setDevelopment(rs.getInt("development"));
				project_assess.setEffect(rs.getInt("effect"));
				project_assess.setVivid(rs.getInt("vivid"));
				project_assess.setAssociation(rs.getInt("association"));
				project_assess.setOther(rs.getString("other"));
				all.add(project_assess);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Project_assess findById(int id) throws Exception {
			Project_assess project_assess=null;

			String sql="select * from project_assess where classId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				project_assess = new Project_assess();
				project_assess.setAssessId(rs.getInt("assessId"));
				project_assess.setStuId(rs.getInt("stuId"));
				project_assess.setProjectId(rs.getInt("projectId"));
				project_assess.setAssessDate(rs.getTimestamp("assessDate"));
				project_assess.setEnvironment(rs.getInt("environment"));
				project_assess.setAbtain(rs.getInt("abtain"));
				project_assess.setDevelopment(rs.getInt("development"));
				project_assess.setEffect(rs.getInt("effect"));
				project_assess.setVivid(rs.getInt("vivid"));
				project_assess.setAssociation(rs.getInt("association"));
				project_assess.setOther(rs.getString("other"));
			}
			pstmt.close();
			return project_assess;
		}
		
		/**
		 * 创建对象，向表中加入一条记录
		 * */
		@Override
		public void doCreate(Project_assess project_assess) throws Exception {
			DaoConn.calcMaxId("project_assess","assessId",conn);
			String sql="insert into project_assess (stuId,projectId,assessDate,environment,abtain,"
					+ "development,effect,vivid,association,other) values(?,?,?,?,?,?,?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,project_assess.getStuId());
			this.pstmt.setInt(2,project_assess.getProjectId());
			this.pstmt.setTimestamp(3,project_assess.getAssessDate());
			this.pstmt.setInt(4,project_assess.getAbtain());
			this.pstmt.setInt(5,project_assess.getDevelopment());
			this.pstmt.setInt(6,project_assess.getEffect());
			this.pstmt.setInt(7,project_assess.getVivid());
			this.pstmt.setInt(8,project_assess.getAssessId());
			this.pstmt.setInt(9,project_assess.getAssociation());
			this.pstmt.setString(10,project_assess.getOther());
			
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(project_assess.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Project_assess project_assess) throws Exception {
			String sql="update project_assess set stuId=? ,projectId=? ,assessDate=?,environment=? ,"
					+ "abtain=? ,development=? ,effect=?,vivid=? ,association=? ,other=? where assessId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,project_assess.getStuId());
			this.pstmt.setInt(2,project_assess.getProjectId());
			this.pstmt.setTimestamp(3,project_assess.getAssessDate());
			this.pstmt.setInt(4,project_assess.getAbtain());
			this.pstmt.setInt(5,project_assess.getDevelopment());
			this.pstmt.setInt(6,project_assess.getEffect());
			this.pstmt.setInt(7,project_assess.getVivid());
			this.pstmt.setInt(8,project_assess.getAssessId());
			this.pstmt.setInt(9,project_assess.getAssociation());
			this.pstmt.setString(10,project_assess.getOther());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from project_assess where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
