package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;

public class ApplianceServiceImpl implements ApplianceService{

	public Appliance find(Criteria criteria) throws ApplianceException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		Appliance appliance = null;
		try {
			appliance = applianceDAO.find(criteria);
		}
		catch (ApplianceException e) {
			throw e;
		}

		return appliance;
	}

	public ArrayList<Appliance> findAll(Criteria criteria) throws ApplianceException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		try {
			return applianceDAO.findAll(criteria);
		} catch (ApplianceException e) {
			throw e;
		}
	}
}