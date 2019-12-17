package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/IncentiveServlet")
public class IncentiveServlet extends HttpServlet {

	@EJB
    IncentiveManagement incentiveManagementObject;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setAttribute("incentiveList", incentiveManagementObject.combineIncentives());
		req.getRequestDispatcher("/manageIncentive.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//int incentiveId = Integer.valueOf(req.getParameter("IncentiveId"));
		String incentiveName = req.getParameter("IncentiveName");
		String incentiveType = req.getParameter("incentive_type");

		if ("Trial".equals(incentiveType)) {

			incentiveManagementObject.create( "Trial", incentiveName);
		} else if ("Promotional".equals(incentiveType)) {

			incentiveManagementObject.create( "Promotional", incentiveName);
		} 
	
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
