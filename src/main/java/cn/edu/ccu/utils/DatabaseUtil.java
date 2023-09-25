package cn.edu.ccu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/smbms?characterEncoding=utf-8";
	private static final String username = "root";
	private static final String password = "3216";

	static {
		//1.加载数据库驱动
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static Connection getConnection() throws SQLException{
		//2.获取数据库连接
		return DriverManager.getConnection(url, username, password);
	}


	//关闭连接
	public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException{
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
	}

	//查询操作
	public static ResultSet querySQL(PreparedStatement pstmt, String preparedSql, Object[] params) throws SQLException {
		ResultSet rs = null;
		if(params != null) {
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		rs = pstmt.executeQuery();
		return rs;
	}

	//增删改操作
	public static int executeSQL(String preparedsql, Object[] params) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(preparedsql);

		if(params != null) {
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		conn.setAutoCommit(false);
		int rows = pstmt.executeUpdate();
		conn.commit();
		closeAll(conn, pstmt, null);
		return rows;
	}
	public static void main(String[] args) {
		String preparedSql = "select * from smbms_user";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(preparedSql);
			ResultSet rs = querySQL(pstmt, preparedSql, null);
			while(rs.next()) {
				System.out.println(rs.getString("userName"));
			}
			closeAll(conn, pstmt, rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
