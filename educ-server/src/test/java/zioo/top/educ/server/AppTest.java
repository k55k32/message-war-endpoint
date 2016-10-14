package zioo.top.educ.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;

import junit.framework.TestCase;
import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("classpath:spring-config/educ-server.xml")
public class AppTest extends TestCase {
	
	@Reference
	UserService userService;

	Logger log = LoggerFactory.getLogger(AppTest.class);

	private User createUser() {
		User user = new User();
		user.setUsername("username");
		user.setEmail("email@qq.com");
		user.setPassword("testpwd");
		return user;
	}

	@Test
	public void registerTest() {
		User user = createUser();
		userService.register(user);
		System.out.println(user.getId());
		assertNotNull(user.getId());
	}
	
	@Test
	public void existsTest() {
		User user = createUser();
		String name = "hello" + System.currentTimeMillis();
		String email = "email" + System.currentTimeMillis() + "@qq.com";
		user.setUsername(name);
		user.setEmail(email);
		userService.register(user);
		
		assertTrue(userService.existsEmail(email));
		assertTrue(userService.existsUsername(name));
	}
}
