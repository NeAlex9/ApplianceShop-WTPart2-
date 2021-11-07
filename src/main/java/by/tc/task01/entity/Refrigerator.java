package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Refrigerator.
 */
public class Refrigerator extends Appliance {
    private int OverallCapacity;
    private int Height;
    private int Width;

    /**
     *
     * @param price refrigerators price.
     * @param overallCapacity refrigerators overall capacity.
     * @param height refrigerators height.
     * @param width refrigerators width.
     */
    public Refrigerator(int price, int overallCapacity, int height, int width) {
        super(price);
        this.Height = height;
        this.Width = width;
        this.OverallCapacity = overallCapacity;
    }

    /**
     * Gets overallCapacity.
     * @return the overallCapacity
     */
    public int getOverallCapacity() {
        return OverallCapacity;
    }

    /**
     * Gets height.
     * @return the height
     */
    public int getHeight() {
        return Height;
    }

    /**
     * Gets width.
     * @return the width
     */
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
