package ssy.reflect;

import java.lang.reflect.Array;

public class ArrayTest {
	
	
	public static void main(String[] args) throws Exception {
		
		Class<?> classType = Class.forName("java.lang.String");
		Object arr = Array.newInstance(classType, 10);
		Array.set(arr, 6, "吉米");
		Array.set(arr, 5, "cjt米");
		
		System.out.println(Array.get(arr, 6));
		
	}

}
