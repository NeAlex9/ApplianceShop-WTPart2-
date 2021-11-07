package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(Appliance... appliances) {
		if (appliances == null){
			throw new NullPointerException("appliance is null");
		}

		for	(var appliance : appliances){
			System.out.println(appliance);
		}
	}
}
