package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.persistence.BeverageManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@WebServlet("/BIFunctionality")
public class BIServlet extends HttpServlet {

    @EJB
    BeverageManagement beverageManagement;

    @EJB
    de.uniba.dsg.dsam.persistence.OrderManagement OrderManagement;

    ArrayList<String> arrayList;

    private static final Logger logger = Logger.getLogger(BIServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        arrayList = new ArrayList<>();
        BICalculation biCalculation = new BICalculation(beverageManagement.getBeverages(),OrderManagement.getOrderList());
        arrayList = biCalculation.calculateRevenu();
        req.setAttribute("total_revenue", arrayList.get(0));
        req.setAttribute("trial_revenue", arrayList.get(1));
        req.setAttribute("promotional_revenue", arrayList.get(2));
        req.setAttribute("non_revenu", arrayList.get(3));
        req.getRequestDispatcher("/BIFunctionality.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
