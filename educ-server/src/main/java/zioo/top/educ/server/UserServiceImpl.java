package zioo.top.educ.server;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

import zioo.educ.commons.utils.PwdUtils;
import zioo.top.educ.api.model.User;
import zioo.top.educ.api.service.UserService;
import zioo.top.educ.api.service.exceptions.AppException;

@Service(validation="true")
@Transactional
public class UserServiceImpl extends BaseService<User, String> implements UserService {

	@Override
	public User login(User user) throws AppException {
		user.setPassword(PwdUtils.pwd(user.getPassword()));
		user = (User) createQuery("from User where username = ? and password = ?")
		.setParameter(0, user.getUsername())
		.setParameter(1, user.getPassword()).uniqueResult();
		if (user == null) {
			throw new AppException(AppException.AUTH_FAILED);
		}
		return user;
	}

	@Override
	public User register(User user) {
		user.setPassword(PwdUtils.pwd(user.getPassword()));
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setEmailIsVaild(false);
		this.save(user);
		return user;
	}

	@Override
	public User getUser(String id) {
		return this.get(id);
	}

	@Override
	public boolean existsUsername(String username) {
		Query q = createQuery("select id from User where username = ?");
		q.setString(0, username);
		return q.uniqueResult() != null;
	}

	@Override
	public boolean existsEmail(String email) {
		Query q = createQuery("select id from User where email = ?").setString(0, email);
		return q.uniqueResult() != null;
	}
}
