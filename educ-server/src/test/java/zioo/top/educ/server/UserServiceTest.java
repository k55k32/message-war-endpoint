package zioo.top.educ.server;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;

import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;
import zioo.top.educ.api.service.exceptions.AppException;

public class UserServiceTest extends BaseTestCase {
	
	@Reference
	UserService userService;
	
	@Test
	public void loginTest () {
		User user = new User();
		try {
			userService.login(user);
		} catch (AppException e) {
			e.printStackTrace();
		} catch (RpcException rpc) {
			
			rpc.printStackTrace();
		}
	}

}
