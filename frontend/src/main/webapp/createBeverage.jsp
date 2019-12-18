<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

  <title>Beverages Creation</title>

</head>

<body class="bg-light" style="background-color:#DCECEC" >
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>Beverages Creation</title>
<div class="container">
  <div class="row row-content">
    <h2>
      <title>Beverages Creation</title>
    </h2>
    <div class="col-sm-3">
      <form role="form" action="BeverageServlet" method="post">
        <div class="form-group">
          <label>Beverage Name</label>
          <input type="text" class="form-control .col-sm-*" name="beverage_name">
        </div>
        <div class="form-group">
          <label>Manufacturer Name</label>
          <input type="text" class="form-control inputsm" name="beverage_manufacturer">
        </div>
        <div class="form-group">
          <input type="hidden" class="form-control inputsm" name="beverage_promotion">
        </div>
        <div class="form-group">
          <label>Quantity</label>
          <input type="text" class="form-control inputsm" name="beverage_quantity">
        </div>
        <div class="form-group">
          <label>Price</label>
          <input type="text" class="form-control inputsm" name="beverage_price">
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
        <a href="/frontend" class="btn bootstrap-theme">Back</a>
      </form>
    </div>
  </div>
</div>
</body>

</html>