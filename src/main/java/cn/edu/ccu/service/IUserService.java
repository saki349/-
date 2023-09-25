package cn.edu.ccu.service;

import java.util.List;

import cn.edu.ccu.domain.User;

public interface IUserService {

	public List<User> selectAll();
	
	public List<User> selsectUserByUsername(String username);
	
	public User selectUserById(Long id);
	
	public Boolean insertUser(User user);
	
	public Boolean updateUser(User user);
	
	public Boolean deleteUser(Long id);
}
