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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oven{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", capacity = ").append(this.getCapacity());
        sb.append(", depth = ").append(this.getDepth());
        sb.append(", width = ").append(this.getWidth());
        sb.append(", height = ").append(this.getHeight());
        sb.append('}');
        return sb.toString();
    }
}
