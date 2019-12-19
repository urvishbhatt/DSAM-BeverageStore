<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bamberg Beverage</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #DCECEC" class="bg-light" >
<form role="form" action="BeverageServlet" method="GET">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class=""><b>Bamberg Beverage Store</b></h1>
			</div>
		</div>
	</div>
</form>
<div class="py-5">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table">
						<thead>
						<tr>
							<th class="h-100" siz="400">Customer Portal<br></th>
							<th class="h-100" siz="400">Salesman Portal</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>
								<p><a href="/frontend/createBeverage" class="btn btn-primary">Beverages Creation</a></p>
								<p><a href="/frontend/createIncentive" class="btn btn-primary">Incentives Creation</a></p>
								<p><a href="/frontend/BeverageServlet" class="btn btn-primary">View Beverages</a></p>
								<p><a href="/frontend/orderList" class="btn btn-primary">View Orders</a></p>
								<p><a href="/frontend/IncentiveServlet" class="btn btn-primary">Manage Incentives</a></p>
								<p><a href="/frontend/BIFunctionality" class="btn btn-primary">BI Functionality</a></p>
							</td>
							<td>
								<p><a href="/frontend/placeOrder" class="btn btn-primary">Order Creation</a></p>
							</td>

						</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>

</html>