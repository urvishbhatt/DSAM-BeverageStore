package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.OrderMessage;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {
	@EJB
    BeverageManagement beverageManagementObject;
	@EJB
    OrderMessage orderObject;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		req.setAttribute("beverageList", beverageManagementObject.getBeverages());
		req.getRequestDispatcher("/placeOrder.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		String BeverageName = req.getParameter("beverage_name").trim();
		String ManufacturerName = req.getParameter("beverage_manufacturer").trim();
		int quantity = Integer.valueOf(req.getParameter("quantity"));

		orderObject.create(BeverageName, ManufacturerName,  quantity);
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException { }
}
