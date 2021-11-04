package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    private final String Path;
    private List<Appliance> Appliances;
    private DocumentBuilder DocumentBuilder;

    public ApplianceDAOImpl() {
        this.Path = "ApplianceInfo.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            this.DocumentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Boolean haveProperty(Map<String, Object> applianceProperties, Map.Entry<String, Object> criteriaProp) {
        for (var property : applianceProperties.entrySet()) {
            if (property.getKey() == criteriaProp.getKey() &&
                    property.getClass().toString() == criteriaProp.getValue().toString()) {
                return true;
            }
        }

        return false;
    }

    private Boolean isSameAppliance(Appliance appliance, Criteria criteria) {
        if (appliance.getClass().toString() == criteria.getGroupSearchName()) {
            for (var criteriaProp : criteria.getCriteria().entrySet()) {
                var haveValue = haveProperty(appliance.getProperties(), criteriaProp);
                if (!haveValue) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private void LoadAppliance() throws ApplianceException {
        List<Appliance> appliances = new ArrayList<>();
        NodeList applianceNodeList = parseXml();
        ApplianceFactory factory = ApplianceFactory.getInstance();
        String applianceType;
        for (int i = 0; i < applianceNodeList.getLength(); i++) {
            Node node = applianceNodeList.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element applianceElement = (Element) node;
                applianceType = applianceElement.getTagName();
                Appliance appliance = factory.getAppliance(applianceType, applianceElement);
                appliances.add(appliance);
            }
        }

        this.Appliances = appliances;
    }

    private NodeList parseXml() throws ApplianceException {
        Document document;
        Element root;
        try {
            document = this.DocumentBuilder.parse(this.Path);
            root = document.getDocumentElement();
        } catch (IOException e) {
            System.err.printf("Error while reading file %s. %s%n", this.Path, e.getMessage());
            throw new ApplianceException("Error while reading file %s. %s%n" + this.Path, e);
        } catch (SAXException e) {
            System.err.printf("Error while parsing file %s. %s%n", this.Path, e.getMessage());
            throw new ApplianceException("Error while parsing file %s. %s%n" + this.Path, e);
        }

        return root.getChildNodes();
    }

    @Override
    public Appliance find(Criteria criteria) throws ApplianceException {
        if (this.Appliances == null) {
            LoadAppliance();
        }

        var appliances = findAll(criteria);
        if (appliances.size() > 0) {
            return appliances.get(0);
        } else {
            throw new ApplianceException("no appliance found");
        }
    }

    @Override
    public Appliance findCheapest(int price) {
        return null;
    }

    @Override
    public ArrayList<Appliance> findAll(Criteria criteria) throws ApplianceException {
        if (this.Appliances == null) {
            LoadAppliance();
        }

        var appliances = new ArrayList<Appliance>();
        for (var appliance : this.Appliances) {
            if (isSameAppliance(appliance, criteria)) {
                appliances.add(appliance);
            }
        }

        return appliances;
    }
}