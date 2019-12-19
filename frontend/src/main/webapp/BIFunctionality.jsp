<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 12/19/2019
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BI Functionality</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Incentive Name</th>
        <th scope="col">Incentive Revenue</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <th>Promotional Incentive</th>
            <%

                String total_revenue = (String)request.getAttribute("total_revenue");
                String trial_revenue = (String) request.getAttribute("trial_revenue");
                String promotional_revenue = (String)request.getAttribute("promotional_revenue");
                String non_revenu = (String) request.getAttribute("non_revenu");

            %>
            <td><%=promotional_revenue%></td>
        </tr>

        <tr>
            <th>Trial Incentive</th>
            <td><%=trial_revenue%></td>
        </tr>

        <tr>
            <th>Non Incentive</th>
            <td><%=non_revenu%></td>
        </tr>

    <thead class="thead-dark">
    <tr>
        <th scope="col">Total Revenue</th>
        <th scope="col"><%=total_revenue%></th>
    </tr>
    </thead>

    </tbody>
</table>


</body>
</html>
