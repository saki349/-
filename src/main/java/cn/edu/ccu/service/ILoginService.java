package cn.edu.ccu.service;

import javax.servlet.http.HttpSession;

public interface ILoginService {
	public Boolean login(HttpSession session, String username, String password);
}
