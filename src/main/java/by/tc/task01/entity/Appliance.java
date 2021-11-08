package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for appliances.
 */
public abstract class Appliance {
    private int Price;

    /**
     * Initialize fields.
     * @param price param describes appliance price.
     */
    public Appliance(int price){
        this.setPrice(price);
    }

    /**
     * Gets price.
     *
     * @return appliance price
     */
    public int getPrice(){
        return this.Price;
    }

    /**
     * Sets price.
     *
     * @param price that sets appliance cost
     */
    public void setPrice(int price){
        this.Price = price;
    }
}
