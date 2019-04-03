package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Show_styleDaoInter;
import com.sjs.dao.vo.Show_style;

public class Show_style_DAOImpl implements Show_styleDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public Show_style_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<Show_style> findAll() throws Exception {
			List<Show_style> all=new ArrayList<Show_style>();
			String sql="select * from show_style";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			Show_style show_style=null;
			while(rs.next()){
				show_style = new Show_style();
				show_style.setShowId(rs.getInt("showId"));
				show_style.setOnlineDate(rs.getTimestamp("onlineDate"));
				show_style.setShowImage(rs.getString("showImage"));
				show_style.setContent(rs.getString("content"));
				all.add(show_style);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public Show_style findById(int id) throws Exception {
			Show_style show_style=null;

			String sql="select * from show_style where showId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				show_style = new Show_style();
				show_style.setShowId(rs.getInt("showId"));
				show_style.setOnlineDate(rs.getTimestamp("onlineDate"));
				show_style.setShowImage(rs.getString("showImage"));
				show_style.setContent(rs.getString("content"));
			}
			pstmt.close();
			return show_style;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(Show_style show_style) throws Exception {
			DaoConn.calcMaxId("show_style","showId",conn);
			String sql="insert into show_style (onlineDate,showImage,content) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setTimestamp(1,show_style.getOnlineDate());
			this.pstmt.setString(2,show_style.getShowImage());
			this.pstmt.setString(3,show_style.getContent());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(show_style.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(Show_style show_style) throws Exception {
			String sql="update show_style set onlineDate=? ,showImage=? ,content=? where showId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setTimestamp(1,show_style.getOnlineDate());
			this.pstmt.setString(2,show_style.getShowImage());
			this.pstmt.setString(3,show_style.getContent());
			this.pstmt.setInt(4,show_style.getShowId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from show_style where classId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
