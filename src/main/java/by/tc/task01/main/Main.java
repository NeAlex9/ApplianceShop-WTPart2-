package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

    /**
     * entry point.
     * @param args
     */
    public static void main(String[] args) {

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        try {
            var cheapest = service.findCheapest();
            PrintApplianceInfo.print(cheapest.toArray(Appliance[]::new));
        } catch (ApplianceException e) {
            System.out.println("Something go wrong");
        }

        System.out.println("/////////////////////////////////////////////////////");

        try {
            var oneCategoryAppliances = service.findByCategory(Refrigerator.class.getSimpleName());
            PrintApplianceInfo.print(oneCategoryAppliances.toArray(Appliance[]::new));
        } catch (ApplianceException e) {
            System.out.println("Something go wrong");
        }
    }
}
