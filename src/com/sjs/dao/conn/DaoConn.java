package com.sjs.dao.conn;
import java.sql.*;
public class DaoConn {
	private Connection con=null;
	
	//实现id自增并连续
	public static void calcMaxId(String tableName,String id,Connection conn) throws SQLException {
		PreparedStatement pstmt = null;			
		String sql1 = "select max("+id+") from "+tableName;
		pstmt=conn.prepareStatement(sql1);
		ResultSet rs = pstmt.executeQuery();
		int maxId = 0;
		while(rs.next()){
			maxId = Integer.valueOf(rs.getString(1));		
		}
		String sql2= "alter table "+tableName+" auto_increment="+(maxId+1);
		pstmt.execute(sql2);
		pstmt.close();
	}
	
	public Connection getConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("驱动错误");
		}

	try{
		String uri="jdbc:mysql://127.0.0.1/studyTour";
		String user="root";
		String password="1234";
		con=DriverManager.getConnection(uri,user,password);		
	}
	catch(SQLException e){
		e.printStackTrace();
		}
	return con;
	}
	public void close() {
		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}

