package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Laptop extends Appliance {

    private int SystemMemory;
    private String Cpu;

    public Laptop(int systemMemory, int price, String cpu) {
        super(price);
        this.Cpu = cpu;
        this.SystemMemory = systemMemory;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", system memory = ").append(this.getSystemMemory());
        sb.append(", cpu = ").append(this.getCpu());
        sb.append('}');
        return sb.toString();
    }

    public int getSystemMemory() {
        return SystemMemory;
    }

    public String getCpu() {
        return Cpu;
    }
}
