package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/EditBeverages")
public class EditBeverageServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(EditBeverageServlet.class.getName());
	
	@EJB
    BeverageManagement beverageManagementObject;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		
		int id = Integer.valueOf(req.getParameter("beverage_id"));
	
	
		Beverage beverageObject = beverageManagementObject.getBeverages(id);
		// add data for JSP
		req.setAttribute("beverageDetail", beverageObject);
		req.getRequestDispatcher("/editBeverage.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int BeverageId = Integer.valueOf(req.getParameter("beverage_id"));
		String BeverageName = req.getParameter("beverage_name").trim();
		String ManufacturerName = req.getParameter("beverage_manufacturer").trim();
		String promotion = req.getParameter("beverage_promotion").trim();
		int quantity = Integer.valueOf(req.getParameter("beverage_quantity"));
		double price = Double.valueOf(req.getParameter("beverage_price"));

		beverageManagementObject.update( BeverageId,  ManufacturerName,  BeverageName, promotion, quantity,  price);
		res.sendRedirect("/frontend/BeverageServlet");
	
	}	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.valueOf(req.getParameter("beverage_id"));

		beverageManagementObject.delete(id);
	}
	
	
}
