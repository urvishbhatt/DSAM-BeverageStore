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

<title>Incentive Management</title>
</head>

<body class="bg-light" style="background-color:#DCECEC">

<div class="container">
<div class="row row-content">
	
	<div class="col-md-2"><h4><b>Incentive Name</b></h4></div>
	<div class="col-md-2"><h4><b>Incentive Type</b></h4></div>
		
</div>

<%  
	
	
		List<Incentive> incentives = (List<Incentive>) request.getAttribute("incentiveList");
		
		for(Incentive inc: incentives) { 
			
		
		%>
		<div class="row ">

			<div class="col-md-2"><h4><%= inc.getName()%></h4></div>
			<div class="col-md-2"><h4><%= inc.getType()%></h4></div>

			<div class="btn-group" role="group">
					<a href="/frontend/EditIncentive?inc_id=<%= inc.getId() %>" class="btn btn-primary">Edit</a>
					<a id="<%= inc.getId() %>" href="/frontend/EditIncentive?inc_id=<%= inc.getId() %>" class="delete btn btn-danger">Delete</a>
			</div>

		</div>
		
		<% }%>

</div>
<script>
	$(document).ready(function() {
		$(".delete").click(function() {
			event.preventDefault();
			$.ajax({
				url: '/frontend/EditIncentive?inc_id=' + event.target.id,
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