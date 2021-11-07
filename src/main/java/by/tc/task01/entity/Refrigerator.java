package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Refrigerator extends Appliance {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Refrigerator{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", overall capacity = ").append(this.getOverallCapacity());
        sb.append(", width = ").append(this.getWidth());
        sb.append(", height = ").append(this.getHeight());
        sb.append('}');
        return sb.toString();
    }
}
