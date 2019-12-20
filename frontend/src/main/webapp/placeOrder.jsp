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


	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

	<title>Place Order</title>

</head>
<body class="bg-light" style="background-color:#DCECEC">
<div class="container">
	<div class="row row-content">
		<h2>Place your order</h2>
		<div class="col-sm-3">

			<form role="form" action="placeOrder" method="post">

				<div class="form-group">
					<label for="exampleFormControlSelect1">Beverage Name</label>
					<select class="form-control" id="exampleFormControlSelect1" name="beverage_name" required>

						<%
							List<Beverage> beverages = (List<Beverage>) request.getAttribute("beverageList");

							for(Beverage bev: beverages) {
						%>
						<option><%= bev.getName() %></option>
						<% } %>
					</select>
				</div>

				<div class="form-group">
					<label for="exampleFormControlSelect2">Manufacturer Name</label>
					<select class="form-control" id="exampleFormControlSelect2" name="beverage_manufacturer" required>

						<%
							List<Beverage> beverages2 = (List<Beverage>) request.getAttribute("beverageList");

							for(Beverage bev: beverages2) {
						%>
						<option><%= bev.getManufacturer() %></option>
						<% } %>
					</select>
				</div>

				<div class="form-group">
					<label>Required Quantity</label>
					<input type="number" class="form-control inputsm" name="quantity" required>
				</div>

				<button type="submit" class="btn btn-success">Submit</button>
			</form>
		</div>

	</div>
</div>

</body>
</html>