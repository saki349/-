package cn.edu.ccu.service.impl;

import java.util.List;

import cn.edu.ccu.dao.UserDao;
import cn.edu.ccu.dao.impl.UserDaoImpl;
import cn.edu.ccu.domain.User;
import cn.edu.ccu.service.IUserService;

public class UserServiceImpl implements IUserService{
	public List<User> selectAll() {
		UserDao user = new UserDaoImpl();
		return user.selectAll();
	}

	public List<User> selsectUserByUsername(String username) {
		UserDao userDao = new UserDaoImpl();
		return userDao.selectUserByUsername(username);
	}

	public User selectUserById(Long id) {
		UserDao userDao = new UserDaoImpl();
		return userDao.selectUserById(id);
	}

	public Boolean insertUser(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.insertUser(user) > 0 ? true : false;
	}

	public Boolean updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.updateUser(user) > 0 ? true : false;
	}

	public Boolean deleteUser(Long id) {
		UserDao userDao = new UserDaoImpl();
		return userDao.deleteUser(id) > 0 ? true : false;
	}
}
