package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class PromotionalGift extends Incentive implements Serializable {
    final String PromotionalGift ="promotionalgift";

    public PromotionalGift(String name) {
        super(name);
    }
    public String getPromotionalGift() {
        return PromotionalGift;
    }
}
