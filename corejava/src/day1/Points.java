package day1;

public class Points {
	public static double ORIGIN = 0;     //it is public static final called constants in java and the variable in all CAPITAL
	private double x;
	private double y;
	
	public Points() {}
	
	// public void Point();
	
	public Points(final double x, final double y) {
		this.x = x;     //current object 
		this.y = y;
	}
	
	//getter and setter
	public final double getX() {
		return x;
	}
	
	public final double getY() {
		return y;
	}
	
	//public abstract void markMeOnScreen();
	
	public double distance() {
		return distance(0,0);
	}
	
	public double distance(Points p) {
		return distance(p.x,p.y);
		
	}
	
	public double distance(final double x1, final double y1) {
		double diffx = x1-x;
		double diffy = y1-y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
	
	public static void main(String[]args) {
		Points p = new Points(10,20);
		System.out.println(p);
		System.out.println(p.distance());
		System.out.println(p.distance(100,200));
		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
		return "Point X = "+x+" Y = "+y+"";
	}
	
	
}
