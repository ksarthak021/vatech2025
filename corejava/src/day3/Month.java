package day3;

public enum Month {
	
	JANUARY(31), FEBRUARY(28), MARCH(31) , APRIL(30) , MAY(31), JUNE(30), JULY(31), 
	AUGUGST(30), SEPTEMBER(31), OCTOBER(30), NOVEMBER(31), DECEMBER(31);
	
	private int noOfDays;
	
	Month(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	@Override
	public String toString() {
		return "MONTH " + name() + "No of Days = " +noOfDays;
		}
	
	public int getnoOfDays() {
		return noOfDays;
	}
	
	public static void main(String[] args) {
		for(Month m : Month.values()) {
			System.out.println(m);
		}
	}

}
