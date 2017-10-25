package ssy.reflect;

import java.lang.reflect.Method;

/**
 * 
 * @author Administrator
 *
 */
public class InvokeTest {

	public String returnMsg(String msg){
		return "this is return: " + msg;
	}
	
	public int add(int a, int b){
		return a + b;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Class<?> classType = InvokeTest.class;
		Object obj = classType.newInstance();
		
		Method[] ms = classType.getDeclaredMethods();
		for (Method method : ms) {
			System.out.println(method);
		}
		
		
		Method addMethod = classType.getMethod("add", new Class[]{int.class, int.class});
		Object result = addMethod.invoke(obj, new Object[]{3, 7});
		System.out.println("add(): " + result);
	}
	
	
}
