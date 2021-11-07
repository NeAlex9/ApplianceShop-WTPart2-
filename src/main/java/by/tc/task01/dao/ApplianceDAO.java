package by.tc.task01.dao;

import by.tc.task01.dao.impl.exceptions.ApplianceException;
import by.tc.task01.entity.Appliance;

import java.util.List;
/**
 * Interface for appliance DAO.
 */
public interface ApplianceDAO {
	/**
	 *
	 * @param category - name of appliance category looking for.
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances
	 */
	List<Appliance> findByCategory(String category) throws ApplianceException;

	/**
	 *
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances.
	 */
	List<Appliance> findCheapest() throws ApplianceException;
}
