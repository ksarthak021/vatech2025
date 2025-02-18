package day2;

import java.util.Random;

public class Authenticator {
	
	public long authenticate(String name, String pass)throws Exception {
		if("scott".equals(name) && "tiger".equals(pass)) {                        //constant.equals(variable name) always write like this 
			return new Random().nextLong();
		}
		throw new Exception("only scott is allowed");
	}

}
