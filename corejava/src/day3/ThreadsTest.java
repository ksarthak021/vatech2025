package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class ThreadsTest {

	@Test
	void test() {
		Runnable r = new Runnable() {
			public void run() {
				for (int i= 0;i<10;i++){
					System.out.println(Thread.currentThread()+" "+i);
				}
			}
		};
		
		new Thread(r).start();                // we should not call the run() method only call the start()
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		
		Thread t = new Thread() {              // another way of starting the thread like the above one
			public void run() {
				for (int i= 0;i<10;i++){
					System.out.println(Thread.currentThread()+" "+i);
				}
			};
		};
		t.start();	
	}
	

}
