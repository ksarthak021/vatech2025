package day2;

import java.util.Iterator;

public class ControlStatements {
	
	public void testIfElse(int a) {
		
		if(a % 2 == 0) {
			System.out.println("A = "+a+" the number is even");
		}   
		else {
			System.out.println("A = "+a+" the number is odd");
		}
	}
	
	public void testfor(int [] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch(a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;                        //break nhi hoga toh ye two three dono dega
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("All others");
		
		}
	}
	
	public int add(String msg,int iv,int ... a) {                    //it is varargs (int ... a) amd it can be only one in the argument 
	//	int sum = 0;
		int sum = iv;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("Sum = "+sum);
		System.out.println(msg + "Sum = "+sum);
		return sum;
	}
	
	public static void main(String[]args) {
		ControlStatements cs = new ControlStatements();
		
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(5);
		cs.testIfElse(8);
		cs.testfor(new int[] {1,2,3});
		cs.testfor(new int [] {1,2,3,4,5});
		cs.testSwitch(11);
		cs.testSwitch(22);
		cs.testSwitch(32);
		cs.testSwitch(333);
		
		//cs.add(1,2);
		//cs.add(1,2,3,4,5);
		//cs.add(1,2,3,4,5,6,7);
		cs.add("Sum of (1,2)",1,2);
		cs.add("Sum of (1,2,3)",1,2,3);
		cs.add("Sum of (1,2,4,5)",1,2,3,4,5);

		//cs.add(1,2,3,4,5);
		//cs.add(1,2,3,4,5,6,7);
	}
	
	

}
