package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public abstract class Appliance {
    private int Price;

    public Appliance(int price){
        this.setPrice(price);
    }

    public int getPrice(){
        return this.Price;
    }

    public void setPrice(int price){
        this.Price = price;
    }
}
