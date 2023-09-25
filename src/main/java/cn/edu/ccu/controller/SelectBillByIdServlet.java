package cn.edu.ccu.controller;

import cn.edu.ccu.domain.Bill;
import cn.edu.ccu.domain.User;
import cn.edu.ccu.service.IBillService;
import cn.edu.ccu.service.IUserService;
import cn.edu.ccu.service.impl.BillServiceImpl;
import cn.edu.ccu.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SelectUserByIdServlet
 */
public class SelectBillByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBillByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.valueOf(request.getParameter("id"));
		
		IBillService billService = new BillServiceImpl();
		
		Bill bill = billService.selectBillById(id);
		
		request.setAttribute("bill", bill);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("billView.jsp");
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
