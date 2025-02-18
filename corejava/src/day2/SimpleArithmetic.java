package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return  a + b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double multi(int a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return  a / b;
	}
	
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return  a / b;
	}


}


