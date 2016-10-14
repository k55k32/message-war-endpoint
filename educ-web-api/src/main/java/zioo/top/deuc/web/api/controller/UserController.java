package zioo.top.deuc.web.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;
import zioo.top.educ.api.service.exceptions.AppException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Reference(validation="true")
	UserService userService;
	
	@RequestMapping("login")
	public User login (User user) throws AppException {
		user = userService.login(user);
		return user;
	}
	
	@RequestMapping("register")
	public User register(User user) throws AppException {
		user = userService.register(user);
		return user;
	}
	
}
