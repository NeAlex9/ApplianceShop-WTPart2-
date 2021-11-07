package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.service.ApplianceService;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> findByCategory(String category) throws ApplianceException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		try {
			return applianceDAO.findByCategory(category);
		} catch (ApplianceException e) {
			throw e;
		}
	}

	@Override
	public List<Appliance> findCheapest() throws ApplianceException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		try {
			return applianceDAO.findCheapest();
		} catch (ApplianceException e) {
			throw e;
		}
	}
}