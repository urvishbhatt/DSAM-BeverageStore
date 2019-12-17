package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AssignIncentive")
public class AssignIncentiveServlet extends HttpServlet {
	
	
	@EJB
    IncentiveManagement incentiveManagementObject;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String BeverageId = req.getParameter("beverage_id");
		req.setAttribute("BeverageId", BeverageId);
		req.setAttribute("incentiveList", incentiveManagementObject.combineIncentives());
		req.getRequestDispatcher("/assignIncentive.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String incentiveId = req.getParameter("incentive_id");
		String incentiveType = req.getParameter("incentive_type");
		
		if ("Trial".equals(incentiveType)) {

			
		}  
		if ("Promotional".equals(incentiveType)) {

			
		}
		if ("None".equals(incentiveType)) {

		}

	res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException { }
}
