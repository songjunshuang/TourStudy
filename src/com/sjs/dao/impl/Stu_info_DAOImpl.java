package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Stu_infoDaoInter;
import com.sjs.dao.vo.Person;
import com.sjs.dao.vo.Stu_info;

public class Stu_info_DAOImpl implements Stu_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Stu_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Stu_info> findAll() throws Exception {
			List<Stu_info> all=new ArrayList<Stu_info>();
			String sql="select * from stu_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Stu_info stu_info=null;
			while(rs.next()){
				stu_info = new Stu_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getString("sex"));
				person.setPassword(rs.getString("password"));
				person.setTel(rs.getString("tel"));
				person.setEmail(rs.getString("email"));
				stu_info.setPerson(person);
				stu_info.setStuId(rs.getInt("stuId"));
				stu_info.setClassId(rs.getInt("classId"));
				stu_info.setParentTel(rs.getString("parentTel"));
				all.add(stu_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Stu_info findById(int id) throws Exception {
			Stu_info stu_info=null;
			String sql="select * from stu_info where stuId=?";
			this.pstmt=this.conn.prepareStatement(sql);					
			this.pstmt.setInt(1,id);
			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				stu_info = new Stu_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getString("sex"));
				person.setPassword(rs.getString("password"));
				person.setTel(rs.getString("tel"));
				person.setEmail(rs.getString("email"));
				stu_info.setPerson(person);
				stu_info.setStuId(rs.getInt("stuId"));
				stu_info.setClassId(rs.getInt("classId"));
				stu_info.setParentTel(rs.getString("parentTel"));
			}
			pstmt.close();
			return stu_info;
		}
		
		@Override
		public Stu_info findByLoginName(String loginName) throws Exception {
			Stu_info stu_info=null;
			String sql="select * from stu_info where loginName=?";
			this.pstmt=this.conn.prepareStatement(sql);					
			this.pstmt.setString(1,loginName);
			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				stu_info = new Stu_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setPassword(rs.getString("password"));
				stu_info.setPerson(person);
			}
			pstmt.close();
			return stu_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Stu_info stu_info) throws Exception {
			DaoConn.calcMaxId("stu_info","stuId",conn);
			String sql="insert into stu_info (loginName,name,sex,password,tel,email,classId,parentTel) values(?,?,?,?,?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,stu_info.getPerson().getLoginName());
			this.pstmt.setString(2,stu_info.getPerson().getName());
			this.pstmt.setString(3,stu_info.getPerson().getSex());
			this.pstmt.setString(4,stu_info.getPerson().getPassword());
			this.pstmt.setString(5,stu_info.getPerson().getTel());
			this.pstmt.setString(6,stu_info.getPerson().getEmail());
			this.pstmt.setInt(7,stu_info.getClassId());
			this.pstmt.setString(8,stu_info.getParentTel());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(stu_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Stu_info stu_info) throws Exception {
			String sql="update stu_info set loginName=? ,name=? ,sex=?,password=? ,tel=? ,email=?,classId=? ,parentTel=? where stuId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,stu_info.getPerson().getLoginName());
			this.pstmt.setString(2,stu_info.getPerson().getName());
			this.pstmt.setString(3,stu_info.getPerson().getSex());
			this.pstmt.setString(4,stu_info.getPerson().getPassword());
			this.pstmt.setString(5,stu_info.getPerson().getTel());
			this.pstmt.setString(6,stu_info.getPerson().getEmail());
			this.pstmt.setInt(7,stu_info.getClassId());
			this.pstmt.setString(8,stu_info.getParentTel());
			this.pstmt.setInt(9,stu_info.getStuId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from stu_info where stuId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
