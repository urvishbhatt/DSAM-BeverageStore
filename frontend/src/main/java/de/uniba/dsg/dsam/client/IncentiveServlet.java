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
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/IncentiveServlet")
public class IncentiveServlet extends HttpServlet {

	@EJB
    IncentiveManagement incentiveManagementObject;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setAttribute("incentiveList", incentiveManagementObject.getAllIncentive());
		req.getRequestDispatcher("/manageIncentive.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String incentiveName = req.getParameter("IncentiveName").trim();
		String incentiveType = req.getParameter("incentive_type").trim();

		Incentive incentive = new Incentive(incentiveName,incentiveType);
		incentiveManagementObject.create(incentive);
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.valueOf(req.getParameter("inc_id"));
		incentiveManagementObject.delete(id);
	}
}
