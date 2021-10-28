package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Appliance {
    private final int Capacity;
    private int Depth;
    private int Height;
    private int Width;

    public Oven(int capacity, int depth, int width, int price, int height) {
        super(price);
        this.Capacity = capacity;
        this.Depth = depth;
        this.Height = height;
        this.Width = width;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getDepth() {
        return Depth;
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
        properties.put("CAPACITY", this.Capacity);
        properties.put("DEPTH", this.Depth);
        properties.put("HEIGHT", this.Height);
        properties.put("WIDTH", this.Width);
        properties.put("PRICE", this.Price);
        return properties;
    }
}
