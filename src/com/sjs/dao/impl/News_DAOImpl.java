package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.NewsDaoInter;
import com.sjs.dao.vo.News;

public class News_DAOImpl implements NewsDaoInter{
		private Connection conn = null;
		private PreparedStatement pstmt = null;		
		public News_DAOImpl(Connection conn){
			this.conn=conn;
		}
			
		/**
		 * 查询所有记录
		 * */
		@Override
		public List<News> findAll() throws Exception {
			List<News> all=new ArrayList<News>();
			String sql="select * from news";
			this.pstmt=this.conn.prepareStatement(sql);
			ResultSet rs= this.pstmt.executeQuery();
			News news=null;
			while(rs.next()){
				news = new News();
				news.setNewsId(rs.getInt("newsId"));
				news.setHappenDate(rs.getTimestamp("happenDate"));
				news.setOnlineDate(rs.getTimestamp("onlineDate"));
				news.setContent(rs.getString("content"));
				all.add(news);		
			}
			pstmt.close();
			return all;		
		}
		
		/**
		 * 查找对象，查询id为固定值的对象
		 * */
		@Override
		public News findById(int id) throws Exception {
			News news=null;

			String sql="select * from news where newsId=?";

			this.pstmt=this.conn.prepareStatement(sql);
					
			this.pstmt.setInt(1,id);

			ResultSet rs= this.pstmt.executeQuery();
			while(rs.next()){
				news = new News();
				news.setNewsId(rs.getInt("newsId"));
				news.setHappenDate(rs.getTimestamp("happenDate"));
				news.setOnlineDate(rs.getTimestamp("onlineDate"));
				news.setContent(rs.getString("content"));
			}
			pstmt.close();
			return news;
		}
		
		/**
		 * 创建对象，像表中加入一条记录
		 * */
		@Override
		public void doCreate(News news) throws Exception {
			DaoConn.calcMaxId("news","newsId",conn);
			String sql="insert into news (happenDate,onlineDate,content) values(?,?,?)";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setTimestamp(1,news.getHappenDate());
			this.pstmt.setTimestamp(2,news.getOnlineDate());
			this.pstmt.setString(3,news.getContent());
//			时间戳类型处理
			//this.pstmt.setTimestamp(6,new Timestamp(news.getCreate_date().getTime()));
			this.pstmt.executeUpdate();
			pstmt.close();
		}
		
		/**
		 * 更新对象，修改记录
		 * */
		@Override
		public void doUpdate(News news) throws Exception {
			String sql="update news set happenDate=? ,onlineDate=? ,content=? where newsId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setTimestamp(1,news.getHappenDate());
			this.pstmt.setTimestamp(2,news.getOnlineDate());
			this.pstmt.setString(3,news.getContent());
			this.pstmt.setInt(4,news.getNewsId());
			this.pstmt.executeUpdate();
			pstmt.close();
			
		}
		
		/**
		 * 删除对象
		 * */
		@Override
		public void doDelete(int[] delList) throws Exception {
			for (int i=0;i<delList.length;i++){
				String sql="delete from news where newsId=?";
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,delList[i]);
				this.pstmt.executeUpdate();
			}
			pstmt.close();			
		}	
}
