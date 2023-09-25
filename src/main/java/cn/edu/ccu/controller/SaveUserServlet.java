package cn.edu.ccu.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ccu.domain.User;
import cn.edu.ccu.service.IUserService;
import cn.edu.ccu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SaveUserServlet
 */
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		User user = new User();
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setPassword(userPassword);
		user.setGender(gender);
		try {
			user.setBirthday(format.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setPhone(phone);
		user.setAddress(address);
		
		HttpSession session = request.getSession();
		
		User loginUser = (User) session.getAttribute("user");

		if(loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		user.setCreateBy(loginUser.getId());
		user.setCreationDate(new Date());
		
		IUserService userService = new UserServiceImpl();
		
		userService.insertUser(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SelectUserListServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
