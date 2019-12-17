package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/EditIncentive")
public class EditIncentiveServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(EditBeverageServlet.class.getName());
	
	@EJB
    IncentiveManagement incentiveManagementObject;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id = Integer.valueOf(req.getParameter("inc_id"));
		Incentive incentiveObject = incentiveManagementObject.getIncentives(id);
		
		// add data for JSP
		req.setAttribute("incentiveDetail", incentiveObject);
		req.getRequestDispatcher("/editIncentive.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String BeverageName = req.getParameter("beverage_name").trim();
		int id = Integer.valueOf(req.getParameter("id"));

		incentiveManagementObject.update( id,  BeverageName);
		// redirect
		res.sendRedirect("/frontend/IncentiveServlet");
	
	}	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.valueOf(req.getParameter("beverage_id"));

	}
	
	
}
