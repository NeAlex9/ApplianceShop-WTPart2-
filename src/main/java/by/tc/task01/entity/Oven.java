package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Oven.
 */
public class Oven extends Appliance {
    private final int Capacity;
    private int Depth;
    private int Height;
    private int Width;

    /**
     * @param capacity ovens capacity.
     * @param depth ovens depth.
     * @param width ovens width.
     * @param price ovens price.
     * @param height ovens height.
     */
    public Oven(int capacity, int depth, int width, int price, int height) {
        super(price);
        this.Capacity = capacity;
        this.Depth = depth;
        this.Height = height;
        this.Width = width;
    }

    /**
     * Gets capacity.
     * @return the capacity.
     */
    public int getCapacity() {
        return Capacity;
    }

    /**
     * Gets depth.
     * @return the depth.
     */
    public int getDepth() {
        return Depth;
    }

    /**
     * Gets height.
     * @return the height.
     */
    public int getHeight() {
        return Height;
    }

    /**
     * Gets width.
     * @return the width.
     */
    public int getWidth() {
        return Width;
    }

    /**
     * gets string representation of oven class
     * @return string representation of oven class.
     */
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
