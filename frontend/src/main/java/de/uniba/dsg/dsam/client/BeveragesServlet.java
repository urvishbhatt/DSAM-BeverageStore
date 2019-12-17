package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.model.TrialPackage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class BeveragesServlet extends HttpServlet {

	@EJB
	BeverageSender beverageSender;

	@EJB
	BeverageManagement beverageManagement;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		List<Beverage> List = beverageManagement.getBeverages();

		if(!List.isEmpty()){
				Logger logger = Logger.getLogger(BeveragesServlet.class.getName());
				logger.severe("MyServerLog" + List.get(0).getName());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String manufacturer = req.getParameter("div_manufacturer").trim();
		String name = req.getParameter("div_name").trim();
		int quantity = Integer.parseInt(req.getParameter("div_quantity").trim());
		double price = Double.valueOf(req.getParameter("div_price").trim());
		String incentive = req.getParameter("incentive").trim();

		PrintWriter out = res.getWriter();
		out.println(name);

		Beverage beverage = new Beverage(manufacturer,name,quantity,price,incentive);

		beverageSender.sendMessage(beverage);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}