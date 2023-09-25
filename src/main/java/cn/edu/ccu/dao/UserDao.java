package cn.edu.ccu.dao;

import java.util.List;

import cn.edu.ccu.domain.User;

public interface UserDao {


	public User selectUserByUsernameAndPassword(String username, String password);

	public List<User> selectAll();
	
	public List<User> selectUserByUsername(String username);

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(Long id);
	
	public User selectUserById(Long id);
}
