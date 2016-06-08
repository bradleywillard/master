package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployeeTester {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Employee emp = new Employee();
	//	emp.pay();
	//	showAnnotations(emp);
		
		if(isLive(emp.getClass(), "processingBonus")) {
			emp.processingBonus();
		}
	}
	
	public static boolean isLive(Class c, String methodName) {
		Method[] methods = c.getMethods();
		
		Optional<Method> opMethod = Stream.of(methods)
				.filter(m -> m.getName().equals(methodName))
				.findFirst();
		Method method = opMethod.get();

		if(method.isAnnotationPresent(DevelopmentInfo.class)) {
			DevelopmentInfo developInfo = 
					method.getAnnotation(DevelopmentInfo.class);
			return developInfo.status()==
					DevelopmentInfo.Status.LIVE;
		}
		return false;
	}
	
	public static void showAnnotations(Employee e) {
		Class c = e.getClass();
		Method[] methods = c.getMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
			Annotation[] annos = m.getAnnotations();
			for(Annotation a : annos) {
				System.out.println(a);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void pay(Employee emp) {
		emp.pay();
	}
}
