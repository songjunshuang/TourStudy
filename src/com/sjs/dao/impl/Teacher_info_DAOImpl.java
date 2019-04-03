package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Teacher_infoDaoInter;
import com.sjs.dao.vo.Person;
import com.sjs.dao.vo.Teacher_info;

public class Teacher_info_DAOImpl implements Teacher_infoDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Teacher_info_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Teacher_info> findAll() throws Exception {
			List<Teacher_info> all=new ArrayList<Teacher_info>();
			String sql="select * from teacher_info";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Teacher_info teacher_info=null;
			while(rs.next()){
				teacher_info = new Teacher_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getString("sex"));
				person.setPassword(rs.getString("password"));
				person.setTel(rs.getString("tel"));
				person.setEmail(rs.getString("email"));
				teacher_info.setPerson(person);
				teacher_info.setTeacherId(rs.getInt("teacherId"));
				teacher_info.setIsheadTeacher(rs.getInt("isheadTeacher"));
				teacher_info.setPhoto(rs.getString("photo"));
				teacher_info.setClassId(rs.getInt("classId"));
				all.add(teacher_info);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Teacher_info findById(int id) throws Exception {
			Teacher_info teacher_info=null;
			String sql="select * from teacher_info where teacherId=?";
			this.pstmt=this.conn.prepareStatement(sql);					
			this.pstmt.setInt(1,id);
			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				teacher_info = new Teacher_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getString("sex"));
				person.setPassword(rs.getString("password"));
				person.setTel(rs.getString("tel"));
				person.setEmail(rs.getString("email"));
				teacher_info.setPerson(person);
				teacher_info.setTeacherId(rs.getInt("teacherId"));
				teacher_info.setIsheadTeacher(rs.getInt("isheadTeacher"));
				teacher_info.setPhoto(rs.getString("photo"));
				teacher_info.setClassId(rs.getInt("classId"));
			}
			pstmt.close();
			return teacher_info;
		}
		
		@Override
		public Teacher_info findByLoginName(String loginName) throws Exception {
			Teacher_info teacher_info=null;
			String sql="select * from teacher_info where loginName=?";
			this.pstmt=this.conn.prepareStatement(sql);					
			this.pstmt.setString(1,loginName);
			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				teacher_info = new Teacher_info();
				Person person = new Person();
				person.setLoginName(rs.getString("loginName"));
				person.setPassword(rs.getString("password"));
				teacher_info.setPerson(person);
			}
			pstmt.close();
			return teacher_info;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Teacher_info teacher_info) throws Exception {
			DaoConn.calcMaxId("teacher_info","teacherId",conn);
			String sql="insert into teacher_info (loginName,name,sex,password,tel,email,isheadTeacher,photo,classId) values(?,?,?,?,?,?,?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,teacher_info.getPerson().getLoginName());
			this.pstmt.setString(2,teacher_info.getPerson().getName());
			this.pstmt.setString(3,teacher_info.getPerson().getSex());
			this.pstmt.setString(4,teacher_info.getPerson().getPassword());
			this.pstmt.setString(5,teacher_info.getPerson().getTel());
			this.pstmt.setString(6,teacher_info.getPerson().getEmail());
			this.pstmt.setInt(7,teacher_info.getIsheadTeacher());
			this.pstmt.setString(8,teacher_info.getPhoto());
			this.pstmt.setInt(9,teacher_info.getClassId());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(teacher_info.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Teacher_info teacher_info) throws Exception {
			String sql="update teacher_info set loginName=? ,name=? ,sex=? ,password=? ,tel=? ,"
					+ "email=?,isheadTeacher=? ,photo=? ,classId=? where teacherId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,teacher_info.getPerson().getLoginName());
			this.pstmt.setString(2,teacher_info.getPerson().getName());
			this.pstmt.setString(3,teacher_info.getPerson().getSex());
			this.pstmt.setString(4,teacher_info.getPerson().getPassword());
			this.pstmt.setString(5,teacher_info.getPerson().getTel());
			this.pstmt.setString(6,teacher_info.getPerson().getEmail());
			this.pstmt.setInt(7,teacher_info.getIsheadTeacher());
			this.pstmt.setString(8,teacher_info.getPhoto());
			this.pstmt.setInt(9,teacher_info.getClassId());
			this.pstmt.setInt(10,teacher_info.getTeacherId());
			
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from teacher_info where teacherId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
