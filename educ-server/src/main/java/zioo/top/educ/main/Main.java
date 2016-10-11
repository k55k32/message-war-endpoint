package zioo.top.educ.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config/educ-server.xml");
		System.out.println("content start:" + context.getBeanDefinitionCount());
		System.in.read();
	}
	
}
