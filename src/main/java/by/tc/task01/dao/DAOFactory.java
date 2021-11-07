package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

/**
 * Factory for creating DAO.
 */
public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory(){}

	/**
	 * Gets applianceDAO.
	 * @return applianceDAO instance;
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	/**
	 * Gets instance.
	 *
	 * @return single factory object
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
}
