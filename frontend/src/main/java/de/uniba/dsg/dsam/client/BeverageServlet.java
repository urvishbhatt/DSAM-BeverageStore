package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.BeverageManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BeverageServlet")
public class BeverageServlet extends HttpServlet {
	
	@EJB
    BeverageManagement beverageManagementObject;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		req.setAttribute("beverageDetail", beverageManagementObject.getBeverages());
		req.getRequestDispatcher("/manageBeverage.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String beverageName = req.getParameter("beverage_name").trim();
		String manufacturerName = req.getParameter("beverage_manufacturer").trim();
		String promotion = req.getParameter("beverage_promotion").trim();
		int quantity = Integer.valueOf(req.getParameter("beverage_quantity"));
		double price = Double.valueOf(req.getParameter("beverage_price"));

		beverageManagementObject.create(manufacturerName, beverageName, promotion, quantity,  price);
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
