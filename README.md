=======

Minimal setup:

- Execute the global build via `gradlew build`
- Deploy the EAR from `ear/build/libs` inside Glassfish, e.g., copy to `%GLASSFISH_HOME%\glassfish\domains\domain1\autodeploy`
- Open `http://localhost:8080/frontend` to see the initial UI of the frontend project
 




=======
=======
# group1
- the front end being the main.jsp
- Beverage Creation  --- create new bevrages 
- Incentive Creation --- Create new Incentive
- Order Creation     --- Create new order ( JMS (Message Driven Beans) is implemented for orders Page
- View Beverage      --- Displays all the created bevrages 
- View Order         --- Displays all the created Oders
- BI Functionality     :-it genrates the total revenue, and revenues with respect to each Incentive




