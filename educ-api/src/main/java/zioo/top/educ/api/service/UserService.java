package zioo.top.educ.api.service;

import zioo.top.educ.api.model.User;

public interface UserService {

	User login(User user);
	
	User register(User user);
	
	boolean existsUsername(String username);
	
	boolean existsEmail(String email);
	
	User getUser(String id);
	
}
