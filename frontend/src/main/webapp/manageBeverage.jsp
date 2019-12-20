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
	<title>View Beverage</title>
</head>

<body class="bg-light" style="background-color:#DCECEC">

<div class="container">
	<h1><b>List of Beverage</b></h1>
	<div class="row row-content">
		<div class="col-md-2"><h4>Name</h4></div>
		<div class="col-md-2"><h4>Manufacturer</h4></div>
		<div class="col-md-2"><h4>Quantity</h4></div>
		<div class="col-md-2"><h4>Price</h4></div>
	</div>

	<%
		List<Beverage> beverages = (List<Beverage>) request.getAttribute("beverageDetail");
		for(Beverage bev: beverages) {
	%>
	<div class="row">
		<div class="col-md-2"><h4><%= bev.getName() %></h4></div>
		<div class="col-md-2"><h4><%= bev.getManufacturer() %></h4></div>
		<div class="col-md-2"><h4><%= bev.getQuantity() %></h4></div>
		<div class="col-md-2"><h4><%= bev.getPrice() %></h4></div>

		<div class="btn-group" role="group">
			<a href="/frontend/EditBeverages?beverage_id=<%= bev.getId() %>" class="btn btn-primary">Edit</a>
			<a  id="<%= bev.getId() %>" href="/frontend/EditBeverages?beverage_id=<%= bev.getId() %>" class="delete btn btn-danger">Delete</a>
			<a  id="<%= bev.getId() %>" href="/frontend/AssignIncentive?beverage_id=<%= bev.getId() %>" class=" btn btn-success">Assign Incentive</a>
		</div>

	</div>
	<% } %>

</div>
<script>
	$(document).ready(function() {
		$(".delete").click(function() {
			event.preventDefault();

			$.ajax({
				url: '/frontend/EditBeverages?beverage_id=' + event.target.id,
				type: 'DELETE',
				success: function(response) {
					location.reload();
				}
			});
		});
	});
</script>
</body>
</html>