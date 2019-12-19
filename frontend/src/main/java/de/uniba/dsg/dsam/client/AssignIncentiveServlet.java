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
import java.io.PrintWriter;


@WebServlet("/AssignIncentive")
public class AssignIncentiveServlet extends HttpServlet {
	
	
	@EJB
    IncentiveManagement incentiveManagementObject;

	@EJB
	BeverageManagement beverageManagement;

	String BeverageId;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		BeverageId = req.getParameter("beverage_id");
		req.setAttribute("BeverageId", BeverageId);
		req.setAttribute("incentiveList", incentiveManagementObject.getAllIncentive());
		req.getRequestDispatcher("/assignIncentive.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String incentiveType = req.getParameter("incentive_type");
		beverageManagement.update(Integer.parseInt(BeverageId),incentiveType);
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException { }
}
