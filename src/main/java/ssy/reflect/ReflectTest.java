package ssy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
	
	
	public Object copyCustomer(Object sourceObj) throws Exception{
		Class<?> classType = sourceObj.getClass();
		Field[] fields = classType.getDeclaredFields();
		
		Constructor cons = classType.getConstructor(new Class[]{});
		Object objectcopy = cons.newInstance(new Object[]{});
		//Object objectcopy = classType.newInstance();  //此行可替代上面2行,无参构造时
		
		for (Field field : fields) {
			String fieldName = field.getName();
			String methodGet = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			String methodSet = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			
			Method getMethod = classType.getMethod(methodGet, new Class[]{});
			Method setMethod = classType.getMethod(methodSet, new Class[]{field.getType()});
			
			Object value = getMethod.invoke(sourceObj, new Object[]{});
			setMethod.invoke(objectcopy, new Object[]{value});
		}
		System.out.println("----------------------------");
		
		return objectcopy;
	}
	

	public static void main(String[] args) throws Exception{
		ReflectTest ts = new ReflectTest();
		//Object object = ts.copyCustomer(new Customer());
		//System.out.println(((Customer)object).getName());
		
		Customer cus = new Customer("吉米", 32);
		cus.setId("cjtid");
		Object object = ts.copyCustomer(cus);
		System.out.println(object);
		
	}

}


class Customer {
	private String id;
	private String name;
	private int age;
	
	public Customer() {
		
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}