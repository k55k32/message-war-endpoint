package zioo.top.deuc.web.api.controller;

import javax.validation.Valid;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import zioo.educ.commons.utils.PwdUtils;
import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;
import zioo.top.educ.api.service.exceptions.AppException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Reference
	UserService userService;
	
	@RequestMapping("login")
	public User login (@Valid @RequestBody User user) throws AppException {
		user.setPassword(PwdUtils.pwd(user.getPassword()));
		user = userService.login(user);
		return user;
	}
	
	@RequestMapping("register")
	public User register(@Valid @RequestBody User user) throws AppException {
		user.setPassword(PwdUtils.pwd(user.getPassword()));
		
		user = userService.register(user);
		return user;
	}
	
}
