package cn.edu.ccu.controller;

import cn.edu.ccu.domain.Bill;
import cn.edu.ccu.service.IBillService;
import cn.edu.ccu.service.impl.BillServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class SelectUserByUsernameServlet
 */
public class SelectBillByProductnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBillByProductnameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productname = request.getParameter("productname");
		
		IBillService billService = new BillServiceImpl();
		
		List<Bill> list = billService.selectBillByProductname(productname);
		
		request.setAttribute("billList", list);

		//请求转发
		RequestDispatcher dispatcher = request.getRequestDispatcher("billList.jsp");
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
