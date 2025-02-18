package com.valtech.training.simpleinterest;

import com.valtech.training.*;
import com.valtech.training.arithmetic.Operation;

public class SimpleInterest {
	
	public int compute(int price,int rate,int time) {
		int product = Operation.MUL.perform(price*rate,time);
		return Operation.DIV.perform(product,100) ;
	}

}
