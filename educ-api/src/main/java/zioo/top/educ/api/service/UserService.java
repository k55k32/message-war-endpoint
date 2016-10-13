package zioo.top.educ.api.service;

import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.exceptions.AppException;

public interface UserService {

	User login(User user) throws AppException;
	
	User register(User user);
	
	boolean existsUsername(String username);
	
	boolean existsEmail(String email);
	
	User getUser(String id);
	
}
