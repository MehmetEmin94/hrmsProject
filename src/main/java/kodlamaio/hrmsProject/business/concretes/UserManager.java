package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.UserService;
import kodlamaio.hrmsProject.core.dataAccess.UserDao;
import kodlamaio.hrmsProject.core.entities.User;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	

}
