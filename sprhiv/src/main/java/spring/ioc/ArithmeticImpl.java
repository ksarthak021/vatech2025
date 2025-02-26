package spring.ioc;

public class ArithmeticImpl implements Arithmetic {
	
	@Override
	public int add(int a, int b) {
		System.out.println("add a = "+a+" b = "+b);
		return a+b;
	}
	
	@Override
	public int sub(int a, int b) {
		System.out.println("sub a = "+a+" b = "+b);
		return a-b;
	}
	
	@Override
	public int mul(int a, int b) {
		System.out.println("mul a = "+a+" b = "+b);
		return a*b;
	}
	
	@Override
	public int div(int a, int b) {
		System.out.println("div a = "+a+" b = "+b);
		return a/b;
	}
	

}
