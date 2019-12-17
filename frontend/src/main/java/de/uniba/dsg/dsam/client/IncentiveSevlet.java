package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IncentiveServlet")
public class IncentiveSevlet extends HttpServlet {

    @EJB
    IncentiveSender incentiveSender;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("incentive_name").trim();
        String description = req.getParameter("incentive_description").trim();
        String incentive = req.getParameter("incentive").trim();
        PrintWriter out = res.getWriter();
        out.println(name);
        Incentive incentiveObj = new Incentive(name,description,incentive);
        incentiveSender.sendMessage(incentiveObj);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

    }
}