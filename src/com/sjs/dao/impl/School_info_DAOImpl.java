package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.School_infoDaoInter;
import com.sjs.dao.vo.School_info;

public class School_info_DAOImpl implements School_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public School_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<School_info> findAll() throws Exception {
			List<School_info> all=new ArrayList<School_info>();
			String sql="select * from school_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			School_info school_info=null;
			while(rs.next()){
				school_info = new School_info();
				school_info.setSchoolId(rs.getInt("schoolId"));
				school_info.setAddress(rs.getString("address"));
				school_info.setName(rs.getString("name"));
				all.add(school_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public School_info findById(int id) throws Exception {
			School_info school_info=null;

			String sql="select * from school_info where schoolId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				school_info = new School_info();
				school_info.setSchoolId(rs.getInt("schoolId"));
				school_info.setAddress(rs.getString("address"));
				school_info.setName(rs.getString("name"));
			}
			pstmt.close();
			return school_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(School_info school_info) throws Exception {
			DaoConn.calcMaxId("school_info","schoolId",conn);
			String sql="insert into school_info (address,name) values(?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,school_info.getAddress());
			this.pstmt.setString(2,school_info.getName());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(school_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(School_info school_info) throws Exception {
			String sql="update school_info set address=? ,name=? where schoolId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,school_info.getAddress());
			this.pstmt.setString(2,school_info.getName());
			this.pstmt.setInt(3,school_info.getSchoolId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from school_info where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
