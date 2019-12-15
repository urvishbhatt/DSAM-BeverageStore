<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 12/11/2019
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

    <form action="add" method="get">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon">Manufacturer</span>
                <input name="div_manufacturer" type="text" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon">Name</span>
                <input name="div_name" type="text" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon">Quantity</span>
                <input name="div_quantity" type="text" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon">Price</span>
                <input name="div_price" type="text" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="input-group">
                <input type="radio" name="incentive" value="promotionalgift">Promotional Gift<br>
                <input type="radio" name="incentive" value="trialpackage">Trial Package<br>
            </div>
        </div>

        <input type="submit">
    </form>

</body>
</html>
