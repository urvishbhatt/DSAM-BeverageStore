package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.OrderManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {

	@EJB
    BeverageManagement beverageManagementObject;

	@EJB
    OrderManagement orderManagement;

	@EJB
	OrderSender orderSender;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setAttribute("beverageList", beverageManagementObject.getBeverages());
		req.getRequestDispatcher("/placeOrder.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		String BeverageName = req.getParameter("beverage_name").trim();
		String ManufacturerName = req.getParameter("beverage_manufacturer").trim();
		int quantity = Integer.valueOf(req.getParameter("quantity"));

		CustomerOrder customerOrder = new CustomerOrder(BeverageName,ManufacturerName,quantity,date);
		orderManagement.create(customerOrder);
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException { }
}
