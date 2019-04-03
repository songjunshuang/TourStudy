package com.sjs.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sjs.dao.conn.DaoConn;
import com.sjs.dao.inter.Manager_infoDaoInter;
import com.sjs.dao.vo.Manager_info;
import com.sjs.dao.vo.Person;

public class Manager_info_DAOImpl implements Manager_infoDaoInter{
	private Connection conn = null;
	private PreparedStatement pstmt = null;		
	public Manager_info_DAOImpl(Connection conn){
		this.conn=conn;
	}
		
	/**
	 * 查询所有记录
	 * */
	@Override
	public List<Manager_info> findAll() throws Exception {
		List<Manager_info> all=new ArrayList<Manager_info>();
		String sql="select * from manager_info";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs= this.pstmt.executeQuery();
		Manager_info manager_info=null;
		while(rs.next()){
			manager_info = new Manager_info();
			Person person = new Person();
			person.setLoginName(rs.getString("loginName"));
			person.setName(rs.getString("name"));
			person.setSex(rs.getString("sex"));
			person.setPassword(rs.getString("password"));
			person.setTel(rs.getString("tel"));
			person.setEmail(rs.getString("email"));
			manager_info.setPerson(person);
			manager_info.setManagerId(rs.getInt("managerId"));
			all.add(manager_info);		
		}
		pstmt.close();
		return all;		
	}
	
	/**
	 * 查找对象，查询id为固定值的对象
	 * */
	@Override
	public Manager_info findById(int id) throws Exception {
		Manager_info manager_info=null;

		String sql="select * from manager_info where classId=?";

		this.pstmt=this.conn.prepareStatement(sql);
				
		this.pstmt.setInt(1,id);

		ResultSet rs= this.pstmt.executeQuery();
		while(rs.next()){
			manager_info = new Manager_info();
			Person person = new Person();
			person.setLoginName(rs.getString("loginName"));
			person.setName(rs.getString("name"));
			person.setSex(rs.getString("sex"));
			person.setPassword(rs.getString("password"));
			person.setTel(rs.getString("tel"));
			person.setEmail(rs.getString("email"));
			manager_info.setPerson(person);
			manager_info.setManagerId(rs.getInt("managerId"));
		}
		pstmt.close();
		return manager_info;
	}
	
	@Override
	public Manager_info findByLoginName(String loginName) throws Exception {
		Manager_info manager_info=null;
		String sql="select * from manager_info where loginName=?";
		this.pstmt=this.conn.prepareStatement(sql);					
		this.pstmt.setString(1,loginName);
		ResultSet rs= this.pstmt.executeQuery();
		while(rs.next()){
			manager_info = new Manager_info();
			Person person = new Person();
			person.setLoginName(rs.getString("loginName"));
			person.setPassword(rs.getString("password"));
			manager_info.setPerson(person);
		}
		pstmt.close();
		return manager_info;
	}
	
	/**
	 * 创建对象，像表中加入一条记录
	 * */
	@Override
	public void doCreate(Manager_info manager_info) throws Exception {
		DaoConn.calcMaxId("manager_info","managerId",conn);
		String sql="insert into manager_info (loginName,name,sex,password,tel,email) values(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,manager_info.getPerson().getLoginName());
		this.pstmt.setString(2,manager_info.getPerson().getName());
		this.pstmt.setString(3,manager_info.getPerson().getSex());
		this.pstmt.setString(4,manager_info.getPerson().getPassword());
		this.pstmt.setString(5,manager_info.getPerson().getTel());
		this.pstmt.setString(6,manager_info.getPerson().getEmail());
//			时间戳类型处理
		//this.pstmt.setTimestamp(6,new Timestamp(manager_info.getCreate_date().getTime()));
		this.pstmt.executeUpdate();
		pstmt.close();
	}
	
	/**
	 * 更新对象，修改记录
	 * */
	@Override
	public void doUpdate(Manager_info manager_info) throws Exception {
		String sql="update manager_info set loginName=? ,name=? ,sex=?,password=? ,tel=? ,email=? where managerId=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,manager_info.getPerson().getLoginName());
		this.pstmt.setString(2,manager_info.getPerson().getName());
		this.pstmt.setString(3,manager_info.getPerson().getSex());
		this.pstmt.setString(4,manager_info.getPerson().getPassword());
		this.pstmt.setString(5,manager_info.getPerson().getTel());
		this.pstmt.setString(6,manager_info.getPerson().getEmail());
		this.pstmt.setInt(7,manager_info.getManagerId());
		this.pstmt.executeUpdate();
		pstmt.close();
		
	}
	
	/**
	 * 删除对象
	 * */
	@Override
	public void doDelete(int[] delList) throws Exception {
		for (int i=0;i<delList.length;i++){
			String sql="delete from manager_info where managerId=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,delList[i]);
			this.pstmt.executeUpdate();
		}
		pstmt.close();			
	}	
}
