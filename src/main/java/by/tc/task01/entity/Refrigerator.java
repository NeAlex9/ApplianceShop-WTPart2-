package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Refrigerator extends Appliance{ //OVERALL_CAPACITY, HEIGHT, WIDTH, PRICE
    private int OverallCapacity;
    private int Height;
    private int Width;
    public Refrigerator(int price, int overallCapacity, int height, int width) {
        super(price);
        this.Height = height;
        this.Width = width;
        this.OverallCapacity = overallCapacity;
    }

    public int getOverallCapacity() {
        return OverallCapacity;
    }

    public int getHeight() {
        return Height;
    }

    public int getWidth() {
        return Width;
    }

    @Override
    public Map<String, Object> getProperties() {
        var properties = new HashMap<String, Object>();
        properties.put("PRICE", this.Price);
        properties.put("HEIGHT", this.Height);
        properties.put("WIDTH", this.Width);
        properties.put("OVERALL_CAPACITY", this.OverallCapacity);
        return properties;
    }
}
