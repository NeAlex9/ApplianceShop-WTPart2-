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
    public Map<String, Object> getProperties() {
        var properties = new HashMap<String, Object>();
        properties.put("PRICE", this.Price);
        properties.put("SYSTEM_MEMORY", this.SystemMemory);
        properties.put("CPU", this.Cpu);
        return properties;
    }

    public int getSystemMemory() {
        return SystemMemory;
    }

    public String getCpu() {
        return Cpu;
    }
}
