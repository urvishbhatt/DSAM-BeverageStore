package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BICalculation {

    public List<Beverage> beverages;
    public List<CustomerOrder> orderList;

    public BICalculation(List<Beverage> beverages, List<CustomerOrder> orderList) {
        this.beverages = beverages;
        this.orderList = orderList;
    }

    public ArrayList<String> calculateRevenu(){
        ArrayList<String> arrayList = new ArrayList<>();
        double totalRevenu = 0;
        double trialRevenu = 0;
        double promotionalRevenu = 0;
        double nonRevenu = 0;

        for(Beverage bevObj : beverages){
            for(CustomerOrder customerOrderObj : orderList){
                if (bevObj.getName().equals(customerOrderObj.getName())){

                    if (bevObj.getPromotion().equals("Trial")){
                        trialRevenu = trialRevenu + (bevObj.getPrice() * customerOrderObj.getQuantity());
                    }else if (bevObj.getPromotion().equals("Promotional")){
                        promotionalRevenu = promotionalRevenu + (bevObj.getPrice() * customerOrderObj.getQuantity());
                    }else {
                        nonRevenu = nonRevenu + (bevObj.getPrice() * customerOrderObj.getQuantity());
                    }

                }
            }
        }
        totalRevenu = trialRevenu + promotionalRevenu + nonRevenu;

        arrayList.add(String.valueOf(totalRevenu));
        arrayList.add(String.valueOf(trialRevenu));
        arrayList.add(String.valueOf(promotionalRevenu));
        arrayList.add(String.valueOf(nonRevenu));
        return arrayList;
    }
}