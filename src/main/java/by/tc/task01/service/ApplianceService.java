package by.tc.task01.service;

import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceService {
	Appliance find(Criteria criteria) throws ApplianceException;
	ArrayList<Appliance> findAll(Criteria criteria) throws ApplianceException;
}
