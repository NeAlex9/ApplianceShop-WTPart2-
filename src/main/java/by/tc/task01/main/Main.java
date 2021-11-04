package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Appliance appliance;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        var dao = DAOFactory.getInstance().getApplianceDAO();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 3);

        try {
            appliance = service.find(criteriaOven);
            PrintApplianceInfo.print(appliance);
        } catch (ApplianceException e) {
            System.out.println(e.getMessage());
        }

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        try {
            appliance = service.find(criteriaOven);
            PrintApplianceInfo.print(appliance);
        } catch (ApplianceException e) {
            System.out.println(e.getMessage());
        }
    }

}
