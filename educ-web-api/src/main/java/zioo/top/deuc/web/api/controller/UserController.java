package zioo.top.deuc.web.api.controller;

import org.educ.commons.utils.PwdUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Reference
	UserService userService;
	
	@RequestMapping("login")
	public User login (User user) {
		user.setPassword(PwdUtils.pwd(user.getPassword()));
		user = userService.login(user);
		return user;
	}
	
}
