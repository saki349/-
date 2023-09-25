package cn.edu.ccu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ccu.service.ILoginService;
import cn.edu.ccu.service.impl.LoginServiceImpl;

/**
 * Servlet 是服务器端运行的Java程序用于响应JSP页面的请求
 * 登录
 * @author Administrator
 * @date
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. 接收前端传过来的参数
		//通过表单input标签的name属性获取
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(username+"/"+password);
		//2.查询数据库，对比用户名，和密码
		//面向接口的编程
		ILoginService loginService = new LoginServiceImpl();
		HttpSession session = request.getSession();
		//3.对比成功，跳转到主页；跳转失败转登录页
		//跳转方式
		//重定向
		if(loginService.login(session, username, password)) {
			response.sendRedirect("main.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
