<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <title>Incentive Creation</title>
</head>

<body class="bg-light" style="background-color:#DCECEC">
<div class="container">
  <div class="row row-content">
    <h1><b>Incentives Creation</b></h1>
    <div class="col-sm-3">
      <form role="form" action="IncentiveServlet" method="post">
        <div class="form-group">
          <label >Name</label>
          <input type="text" class="form-control .col-sm-*" name="IncentiveName" required>
        </div>
        <div class="form-group">
          <label>Type</label>
          <div class="radio">
            <label><input type="radio" name="incentive_type" value="Trial" checked="">Trial</label>
          </div>
          <div class="radio">
            <label><input type="radio" name="incentive_type" value="Promotional">Promotional</label>
          </div>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
    </div>
  </div>
</div>
</body>

</html>