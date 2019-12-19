package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;

import java.util.List;
import java.util.logging.Logger;

public class BICalculation {

    private static final Logger logger = Logger.getLogger(BICalculation.class.getName());

    public List<Beverage> beverages;
    public List<CustomerOrder> orderList;



    public BICalculation(List<Beverage> beverages, List<CustomerOrder> orderList) {
        this.beverages = beverages;
        this.orderList = orderList;
    }

    public void calculateRevenu(){
        for(Beverage bevObj : beverages){
            for(CustomerOrder customerOrderObj : orderList){
                if (bevObj.getName().equals(customerOrderObj.getName())){
                    logger.severe("Our Test :- " + bevObj.getName() + customerOrderObj.getName());

                }
            }
        }
    }

}
