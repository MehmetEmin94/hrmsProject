package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;

public interface EmployerAuthService {

	Result register(Employer employer,String confirmPassword);
}
