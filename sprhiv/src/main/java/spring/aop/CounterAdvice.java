package spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice{
	
	private Map<String, Integer> counters;
	
	public void any() {
		System.out.println("inting counters....");
		counters = new HashMap<String, Integer>();
	}
	
	public void any1() {
		System.out.println("counters = "+ counters);
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Method = "+method.getName()+" with Args = "+ Arrays.toString(args));
		String methodName = method.getName();
		if(counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName)+1);
		} else {
			counters.put(methodName, 1);
		}
	}

}
