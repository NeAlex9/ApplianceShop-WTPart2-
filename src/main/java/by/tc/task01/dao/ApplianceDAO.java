package by.tc.task01.dao;

import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> findByCategory(String category) throws ApplianceException;
	List<Appliance> findCheapest() throws ApplianceException;
}
