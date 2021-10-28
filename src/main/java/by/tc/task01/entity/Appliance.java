package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public abstract class Appliance {
    protected int Price;
    public abstract Map<String, Object> getProperties();

    public Appliance(int price){
        this.Price = price;
    }
}
