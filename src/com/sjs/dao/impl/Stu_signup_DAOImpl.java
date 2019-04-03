package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Stu_signupDaoInter;
import com.sjs.dao.vo.Stu_signup;

public class Stu_signup_DAOImpl implements Stu_signupDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Stu_signup_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Stu_signup> findAll() throws Exception {
			List<Stu_signup> all=new ArrayList<Stu_signup>();
			String sql="select * from stu_signup";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Stu_signup stu_signup=null;
			while(rs.next()){
				stu_signup = new Stu_signup();
				stu_signup.setStuorderId(rs.getInt("stuorderId"));
				stu_signup.setGroupOrderId(rs.getInt("groupOrderId"));
				stu_signup.setStuId(rs.getInt("stuId"));
				all.add(stu_signup);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Stu_signup findById(int id) throws Exception {
			Stu_signup stu_signup=null;

			String sql="select * from stu_signup where classId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				stu_signup = new Stu_signup();
				stu_signup.setStuorderId(rs.getInt("stuorderId"));
				stu_signup.setGroupOrderId(rs.getInt("groupOrderId"));
				stu_signup.setStuId(rs.getInt("stuId"));
			}
			pstmt.close();
			return stu_signup;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Stu_signup stu_signup) throws Exception {
			DaoConn.calcMaxId("stu_signup","stuorderId",conn);
			String sql="insert into stu_signup (groupOrderId,stuId) values(?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,stu_signup.getGroupOrderId());
			this.pstmt.setInt(2,stu_signup.getStuId());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(stu_signup.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Stu_signup stu_signup) throws Exception {
			String sql="update stu_signup set groupOrderId=? ,stuId=? where stuorderId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,stu_signup.getGroupOrderId());
			this.pstmt.setInt(2,stu_signup.getStuId());
			this.pstmt.setInt(3,stu_signup.getStuorderId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from stu_signup where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
