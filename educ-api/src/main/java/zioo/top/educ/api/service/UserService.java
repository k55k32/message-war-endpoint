package zioo.top.educ.api.service;

import org.hibernate.validator.constraints.NotBlank;

import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.exceptions.AppException;

public interface UserService {

	User login(User user) throws AppException;
	
	@interface Register{}
	User register(User user);
	
	boolean existsUsername(@NotBlank(message="username is required") String username);
	
	boolean existsEmail(@NotBlank(message="email is required") String email);
	
	User getUser(@NotBlank(message="id is required") String id);
	
}
