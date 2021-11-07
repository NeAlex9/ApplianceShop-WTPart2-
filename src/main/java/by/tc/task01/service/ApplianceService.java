package by.tc.task01.service;

import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;

import java.util.ArrayList;
import java.util.List;

public interface ApplianceService {
	List<Appliance> findByCategory(String category) throws ApplianceException;
	List<Appliance> findCheapest() throws ApplianceException;
}
