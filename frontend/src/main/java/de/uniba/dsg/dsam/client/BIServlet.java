package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.OrderMessage;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BIFunctionality")
public class BIServlet extends HttpServlet {

    @EJB
    BeverageManagement beverageManagement;

    @EJB
    OrderMessage OrderManagement;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BICalculation biCalculation = new BICalculation(beverageManagement.getBeverages(),OrderManagement.getOrderList());
        biCalculation.calculateRevenu();
        req.getRequestDispatcher("/BIFunctionality.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
