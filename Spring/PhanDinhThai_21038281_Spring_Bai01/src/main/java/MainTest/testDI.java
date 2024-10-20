package MainTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entites.Employee;

public class testDI {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di/applicationContext.xml");
		Employee emp = (Employee) context.getBean("Employee");
		emp.display();
	}
}
