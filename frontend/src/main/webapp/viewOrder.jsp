<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="de.uniba.dsg.dsam.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>view Order</title>
</head>

<body class="bg-light" style="background-color:#DCECEC">
 <div class="container">
        <div class="row row-content">
            <h1><b>List of Orders</b></h1>
            <div class="col-md-3"><h4><b>Name</b></h4></div>
            <div class="col-md-2"><h4><b>Manufacturer</b></h4></div>
            <div class="col-md-2"><h4><b>Quantity</b></h4></div>
            <div class="col-md-2"><h4><b>Date</b></h4></div>
        </div>
        <%
            List<CustomerOrder> customerOrders = (List<CustomerOrder>) request.getAttribute("orderList");

            for(CustomerOrder order: customerOrders) {
        %>
        <div class="row">
            <div class="col-md-3"><h4><%= order.getName() %></h4></div>
            <div class="col-md-2"><h4><%= order.getManufacturer() %></h4></div>
            <div class="col-md-2"><h4><%= order.getQuantity() %></h4></div>
            <div class="col-md-2"><h4><%= order.getIssueDate() %></h4></div>
        </div>
        <% } %>
    </div>
</body>
</html>