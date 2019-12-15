package de.uniba.dsg.dsam.client;

<<<<<<< HEAD

=======
>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.model.TrialPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeveragesServlet extends HttpServlet {

	@EJB
	BeverageSender beverageSender;
<<<<<<< HEAD
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

=======

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String manufacturer = req.getParameter("div_manufacturer").trim();
		String name = req.getParameter("div_name").trim();
		int quantity = Integer.parseInt(req.getParameter("div_quantity").trim());
		double price = Double.valueOf(req.getParameter("div_price").trim());

		String incentive = req.getParameter("incentive").trim();

		PrintWriter out = res.getWriter();
		out.println(name);

		Beverage beverage;
		if (incentive.equals("promotionalgift")){
			PromotionalGift promotionalGift = new PromotionalGift("promotionalgift");
			Incentive incentiveObj = new Incentive(promotionalGift.getPromotionalGift());
			beverage = new Beverage(manufacturer,name,quantity,price,incentiveObj);
		}else {
			TrialPackage trialPackage = new TrialPackage("trialpackage");
			Incentive incentiveObj = new Incentive(trialPackage.getTrialPackage());
			beverage = new Beverage(manufacturer, name, quantity, price, incentiveObj);
		}
		beverageSender.sendMessage(beverage);
>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String manufacturer = req.getParameter("div_manufacturer").trim();
		String name = req.getParameter("div_name").trim();
		int quantity = Integer.parseInt(req.getParameter("div_quantity").trim());
		double price = Double.valueOf(req.getParameter("div_price").trim());
<<<<<<< HEAD
		String incentive = req.getParameter( "incentive").trim();

		PrintWriter out = res.getWriter();
		out.println(name);
		out.println(quantity);
		out.println(incentive);
		out.println(manufacturer);
		System.out.println(name);
		Beverage beverage;
		if(incentive.equals("promotionalgift")){
			PromotionalGift promotionalgift= new PromotionalGift(incentive);
			Incentive incentiveObj= new Incentive(promotionalgift.getPromotionalGift());
			out.println(incentiveObj.getName());
			beverage = new Beverage(manufacturer,name,quantity,price,incentiveObj) ;

		}
		else{
			TrialPackage trialPackage= new TrialPackage(incentive);
			Incentive incentiveObj= new Incentive(trialPackage.getTrialPackage());
			out.println(incentiveObj.getName());
			beverage = new Beverage(manufacturer,name,quantity,price,incentiveObj) ;
		}
		beverageSender.sendMessage(beverage);
	}


=======

		String incentive = req.getParameter("incentive").trim();

		PrintWriter out = res.getWriter();
		out.println(name);

		Beverage beverage;
		if (incentive.equals("promotionalgift")){
			PromotionalGift promotionalGift = new PromotionalGift("promotionalgift");
			Incentive incentiveObj = new Incentive(promotionalGift.getPromotionalGift());
			beverage = new Beverage(manufacturer,name,quantity,price,incentiveObj);
		}else {
			TrialPackage trialPackage = new TrialPackage("trialpackage");
			Incentive incentiveObj = new Incentive(trialPackage.getTrialPackage());
			beverage = new Beverage(manufacturer, name, quantity, price, incentiveObj);
		}
		beverageSender.sendMessage(beverage);
	}
>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
