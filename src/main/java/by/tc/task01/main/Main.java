package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.impl.exceptions.NoApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();
		var dao = DAOFactory.getInstance().getApplianceDAO();
		dao.saveAppliance("ApplianceInfo.xml");

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 3);

		try {
			appliance = service.find(criteriaOven);
			PrintApplianceInfo.print(appliance);
		} catch (NoApplianceException e) {
			System.out.println("No appliance with such criteria");
		}

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);

		try {
			appliance = service.find(criteriaOven);
			PrintApplianceInfo.print(appliance);
		} catch (NoApplianceException e) {
			System.out.println("No appliance with such criteria");
		}
	}

}
