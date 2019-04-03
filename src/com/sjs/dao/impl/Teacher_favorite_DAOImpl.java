package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Teacher_favoriteDaoInter;
import com.sjs.dao.vo.Teacher_favorite;

public class Teacher_favorite_DAOImpl implements Teacher_favoriteDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Teacher_favorite_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Teacher_favorite> findAll() throws Exception {
			List<Teacher_favorite> all=new ArrayList<Teacher_favorite>();
			String sql="select * from teacher_favorite";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Teacher_favorite teacher_favorite=null;
			while(rs.next()){
				teacher_favorite = new Teacher_favorite();
				teacher_favorite.setFavoriteId(rs.getInt("favoriteId"));
				teacher_favorite.setProjectId(rs.getInt("projectId"));
				teacher_favorite.setTeacherId(rs.getInt("teacherId"));
				teacher_favorite.setCollecTime(rs.getTimestamp("collecTime"));
				all.add(teacher_favorite);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Teacher_favorite findById(int id) throws Exception {
			Teacher_favorite teacher_favorite=null;

			String sql="select * from teacher_favorite where classId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				teacher_favorite = new Teacher_favorite();
				teacher_favorite.setFavoriteId(rs.getInt("favoriteId"));
				teacher_favorite.setProjectId(rs.getInt("projectId"));
				teacher_favorite.setTeacherId(rs.getInt("teacherId"));
				teacher_favorite.setCollecTime(rs.getTimestamp("collecTime"));
			}
			pstmt.close();
			return teacher_favorite;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Teacher_favorite teacher_favorite) throws Exception {
			DaoConn.calcMaxId("teacher_favorite","favoriteId",conn);
			String sql="insert into teacher_favorite (projectId,teacherId,collecTime) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,teacher_favorite.getProjectId());
			this.pstmt.setInt(2,teacher_favorite.getTeacherId());
			this.pstmt.setTimestamp(3,teacher_favorite.getCollecTime());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(teacher_favorite.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Teacher_favorite teacher_favorite) throws Exception {
			String sql="update teacher_favorite set projectId=? ,teacherId=? ,collecTime=? where favoriteId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,teacher_favorite.getProjectId());
			this.pstmt.setInt(2,teacher_favorite.getTeacherId());
			this.pstmt.setTimestamp(3,teacher_favorite.getCollecTime());
			this.pstmt.setInt(4,teacher_favorite.getFavoriteId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from teacher_favorite where favoriteId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
