package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Ref;

public class ApplianceFactory {
    private static final ApplianceFactory instance = new ApplianceFactory();

    public static ApplianceFactory getInstance() {
        return instance;
    }

    private ApplianceFactory() {
    }

    public Appliance getAppliance(String applianceType, Object element) throws Exception {
        Appliance appliance;
        if (element.getClass().getSimpleName().equals("DeferredElementImpl")) {
            appliance = getApplianceFromXml(applianceType, (Element) element);
        } else {
            System.err.println("Invalid format");
            throw new Exception("Invalid format");
        }
        return appliance;
    }

    private Appliance getApplianceFromXml(String applianceType, Element element) {
        Appliance appliance;
        switch (applianceType) {
            case "OVEN" -> {
                appliance = (Oven) createOven(element);
            }
            case "LAPTOP" -> {
                appliance = (Laptop) createLaptop(element);
            }
            case "REFRIGERATOR" -> {
                appliance = (Refrigerator) createRefrigerator(element);
            }
            default -> {
                appliance = null;
            }
        }

        return appliance;
    }

    private Appliance createLaptop(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Laptop.PRICE.toString()));
        var sysMemory = Integer.parseInt(getElementTextContent(element, SearchCriteria.Laptop.SYSTEM_MEMORY.toString()));
        var cpu = getElementTextContent(element, SearchCriteria.Laptop.CPU.toString());
        return new Laptop(sysMemory, price, cpu);
    }

    private Appliance createOven(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Laptop.PRICE.toString()));
        var capacity = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.CAPACITY.toString()));
        var depth = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.DEPTH.toString()));
        var height = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.HEIGHT.toString()));
        var width = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.WIDTH.toString()));
        return new Oven(capacity, depth, width, price, height);
    }

    private Appliance createRefrigerator(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.PRICE.toString()));
        var width = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.WIDTH.toString()));
        var height = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.HEIGHT.toString()));
        var capacity = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()));
        return new Refrigerator(price, capacity, height, width);
    }

    private static String getElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() == 0) {
            System.err.printf("Element %s doesn't contain tag %s%n", element, tagName);
        }
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
