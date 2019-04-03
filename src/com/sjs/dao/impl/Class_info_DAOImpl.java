package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Class_infoDaoInter;
import com.sjs.dao.vo.Class_info;

public class Class_info_DAOImpl implements Class_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Class_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Class_info> findAll() throws Exception {
			List<Class_info> all=new ArrayList<Class_info>();
			String sql="select * from class_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Class_info class_info=null;
			while(rs.next()){
				class_info = new Class_info();
				class_info.setClassId(rs.getInt("classId"));
				class_info.setName(rs.getString("name"));
				class_info.setSchoolId(rs.getInt("schoolId"));
				class_info.setStuCount(rs.getInt("stuCount"));
				all.add(class_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Class_info findById(int id) throws Exception {
			Class_info class_info=null;

			String sql="select * from class_info where classId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				class_info = new Class_info();
				class_info.setClassId(rs.getInt("classId"));
				class_info.setName(rs.getString("name"));
				class_info.setSchoolId(rs.getInt("schoolId"));
				class_info.setStuCount(rs.getInt("stuCount"));
			}
			pstmt.close();
			return class_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Class_info class_info) throws Exception {
			DaoConn.calcMaxId("class_info","classId",conn);
			String sql="insert into class_info (schoolId,name,stuCount) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,class_info.getSchoolId());
			this.pstmt.setString(2,class_info.getName());
			this.pstmt.setInt(3,class_info.getStuCount());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(Class_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Class_info class_info) throws Exception {
			String sql="update class_info set schoolId=? ,name=? ,stuCount=? where classId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,class_info.getSchoolId());
			this.pstmt.setString(2,class_info.getName());
			this.pstmt.setInt(3,class_info.getStuCount());
			this.pstmt.setInt(4,class_info.getClassId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from class_info where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
