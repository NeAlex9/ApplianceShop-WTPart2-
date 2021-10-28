package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.impl.exceptions.NoApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    private ArrayList<Appliance> Appliances;

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

    private void loadAppliance(String path) {
        /*XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
        File file = new File("simple_bean.xml");*/
    }

    @Override
    public Appliance find(Criteria criteria) throws NoApplianceException {
        var appliances = findAll(criteria);
        if (appliances.size() > 0) {
            return appliances.get(0);
        } else {
            throw new NoApplianceException("");
        }
    }

    @Override
    public Appliance findCheapest(int price) {
        return null;
    }

    @Override
    public ArrayList<Appliance> findAll(Criteria criteria) {
        var appliances = new ArrayList<Appliance>();
        for (var appliance : this.Appliances) {
            if (isSameAppliance(appliance, criteria)) {
                appliances.add(appliance);
            }
        }

        return appliances;
    }

    public ArrayList<Appliance> getAppliances() {
        return Appliances;
    }
}