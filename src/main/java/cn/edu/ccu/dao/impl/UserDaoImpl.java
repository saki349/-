package cn.edu.ccu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccu.dao.UserDao;
import cn.edu.ccu.domain.User;
import cn.edu.ccu.utils.DatabaseUtil;

public class UserDaoImpl implements UserDao{

	public User selectUserByUsernameAndPassword(String username, String password) {
		//sql语句中的？是占位符，通过PreparedStatment传参
		String sql = "select * from smbms_user where userCode = ? and userPassword = ?;";
		User user = new User();
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = DatabaseUtil.querySQL(pstmt, sql, new String[]{username, password});


			if(rs.next()) {
				user.setId(rs.getLong("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setCreateBy(rs.getLong("createdBy"));
				user.setCreationDate(rs.getDate("creationDate"));
				
//				user.setModifyBy(rs.getLong("modifyBy"));
//				user.setModifyDate(rs.getDate("modifyDate"));
			}
			
			DatabaseUtil.closeAll(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	
	public List<User> selectAll() {
		String sql = "select * from smbms_user";
		List<User> list = new ArrayList<User>();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = DatabaseUtil.querySQL(pstmt, sql, null);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setCreateBy(rs.getLong("createdBy"));
				user.setCreationDate(rs.getDate("creationDate"));
//				user.setModifyBy(rs.getLong("modifyBy"));
//				user.setModifyDate(rs.getDate("modifyDate"));
				list.add(user);
			}

			DatabaseUtil.closeAll(conn, pstmt, rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<User> selectUserByUsername(String username) {
		String sql = "select * from smbms_user where userName like ?;";
		String like = "%" + username + "%";
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = DatabaseUtil.querySQL(pstmt, sql, new String[] {like});
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setCreateBy(rs.getLong("createdBy"));
				user.setCreationDate(rs.getDate("creationDate"));
//				user.setModifyBy(rs.getLong("modifyBy"));
//				user.setModifyDate(rs.getDate("modifyDate"));
				list.add(user);
			}
			DatabaseUtil.closeAll(conn, pstmt, rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insertUser(User user) {
		String sql = "insert into smbms_user (userCode, userName, userPassword, gender, birthday, phone, address, createdBy, creationDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int rows = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String birthday = format.format(user.getBirthday());
		String creationDate = format.format(user.getCreationDate());
		try {
			rows = DatabaseUtil.executeSQL(sql, new Object[] {
					user.getUserCode(), 
					user.getUserName(),
					user.getPassword(),
					user.getGender(),
					birthday,
					user.getPhone(),
					user.getAddress(),
					user.getCreateBy(),
					creationDate
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	public int updateUser(User user) {
		String sql = "Update smbms_user set userCode = ?, userName = ?, userPassword = ?, gender = ?, birthday = ?, phone = ?, address = ?, modifyBy = ?, modifyDate = ? where id = ?;";
		int rows = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String birthday = format.format(user.getBirthday());
		String modifyDate = format.format(user.getModifyDate());
		try {
			rows = DatabaseUtil.executeSQL(sql, new Object[] {
					user.getUserCode(), 
					user.getUserName(),
					user.getPassword(),
					user.getGender(),
					birthday,
					user.getPhone(),
					user.getAddress(),
					user.getModifyBy(),
					modifyDate,
					user.getId()
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	public int deleteUser(Long id) {
		String sql = "delete from smbms_user where id = ?;";
		int rows = 0;
		try {
			rows = DatabaseUtil.executeSQL(sql, new Long[] {id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	public User selectUserById(Long id) {
		String sql = "select * from smbms_user where id=?;";
		User user = null;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = DatabaseUtil.querySQL(pstmt, sql, new Long[]{id});
			while(rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setCreateBy(rs.getLong("createBy"));
				user.setCreationDate(rs.getDate("creationDate"));
				user.setModifyBy(rs.getLong("modifyBy"));
				user.setModifyDate(rs.getDate("modifyDate"));
			}
			DatabaseUtil.closeAll(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	} 
}
