package by.tc.task01.dao;

import by.tc.task01.dao.impl.exceptions.NoApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceDAO {
	Appliance find(Criteria criteria) throws Exception;
	Appliance findCheapest(int price);
	ArrayList<Appliance> findAll(Criteria criteria) throws Exception;
}
