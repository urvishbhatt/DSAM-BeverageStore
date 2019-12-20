==========================================GROUP 1==================================================

Minimal setup:
- Java 8(1.8), Glassfish 4.1 or 5, PostgreSQL ,IDE

How to run
- Download Postgresql.jar and paste into lib folder into Glassfish(glassfish4\glassfish\domains\domain1\lib)
- Give the glassfish path in the  gradle.properties 
- Create   Database "BeverageStore" and assign role as a  "tester" according to the gradle.properties/Database environment in Pgadmin.
-Run the following commands:
   -gradle startGlassfish
   -gradle initServer
   -gradle build
   -gradle deploy
- Open `http://localhost:8080/frontend` to see the initial UI of the frontend project   
- initial UI contain both customer and salesman part.
=============================================================================================
- the front end being the main.jsp
- Beverage Creation  --- create new beverages 
- Incentive Creation --- Create new Incentive
- Order Creation     --- Create new order ( JMS (Message Driven Beans) is implemented for orders Page
                     --- the dropdown returns the list of the beverages and its manufacture in the order creation page.
                     
- View Beverage      --- Displays all the created beverages 
- View Order         --- Displays all the created Orders
- Manage Incentives  --- Can Edit and delete incentives 
- BI Functionality     :-it generates the total revenue, and revenues with respect to each Incentive

=============================================================================================================

Stateful :
In our Assignment we have used stateful, 
A Stateful application saves data about each client session and uses that data the next time the client makes a request.
Since it is a Beverage management Store ,and using stateful or stateless depends on the conversational state and 
Since we do create order Each time , its Good to use Stateful , Since it serves the request  of the client with the same
bean, unlike Stateless which uses new bean for every request.
===========================================================================================================