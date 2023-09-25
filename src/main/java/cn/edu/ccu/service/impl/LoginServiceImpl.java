package cn.edu.ccu.service.impl;

import javax.servlet.http.HttpSession;

import cn.edu.ccu.dao.UserDao;
import cn.edu.ccu.dao.impl.UserDaoImpl;
import cn.edu.ccu.domain.User;
import cn.edu.ccu.service.ILoginService;

public class LoginServiceImpl implements ILoginService{

	//重写login
	public Boolean login(HttpSession session, String username, String password) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUserByUsernameAndPassword(username, password);


		if(user.getId() != null) {
			session.setAttribute("user", user);
		}
		
		return user.getId() == null ? false : true;
	}
}
