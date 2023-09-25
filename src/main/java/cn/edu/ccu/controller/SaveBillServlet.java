package cn.edu.ccu.controller;

import cn.edu.ccu.domain.Bill;
import cn.edu.ccu.service.IBillService;
import cn.edu.ccu.service.impl.BillServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class SaveUserServlet
 */
public class SaveBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBillServlet() {
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

		String id = request.getParameter("id");
		String billCode = request.getParameter("billCode");
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String productUnit = request.getParameter("productUnit");
		Long productCount = new Long(request.getParameter("productCount"));
		Long totalPrice = new Long(request.getParameter("totalPrice"));
		String is=request.getParameter("isPayment");
		int isPayment = Integer.parseInt(is);
		String creationDate=request.getParameter("creationDate");
		String modifiedDate=request.getParameter("modifiedDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Bill bill = new Bill();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(productCount);
		bill.setTotalPrice(totalPrice);
		bill.setIsPayment(isPayment);
		bill.setModifyBy(2L);

		Date date=new Date();

		bill.setCreationDate(date);
		bill.setModifyDate(date);


		HttpSession session = request.getSession();


		bill.setCreateBy(1L);
		bill.setCreationDate(date);

		IBillService billService = new BillServiceImpl();

		billService.insertBill(bill);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SelectBillListServlet");
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
