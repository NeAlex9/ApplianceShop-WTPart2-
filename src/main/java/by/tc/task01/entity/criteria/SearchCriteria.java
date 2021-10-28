package by.tc.task01.entity.criteria;

public final class SearchCriteria {
	
	public static enum Oven{
		CAPACITY, DEPTH, HEIGHT, WIDTH, PRICE
	}
	
	public static enum Laptop{
		SYSTEM_MEMORY, CPU, PRICE
	}
	
	public static enum Refrigerator{
		OVERALL_CAPACITY, HEIGHT, WIDTH, PRICE
	}

	private SearchCriteria() {}
}

