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


@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(OrderServlet.class.getName());

	@EJB
    OrderMessage orderMessageObject;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setAttribute("orderList", orderMessageObject.getOrderList());
		req.getRequestDispatcher("/viewOrder.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}
}
