package spring.ioc;

import spring.ioc.test.Point;

public class PointFactory {
	
	static int i;
	public static Point createPoint() {
		
		return new Point(i++,i);
	}
	
	

}
