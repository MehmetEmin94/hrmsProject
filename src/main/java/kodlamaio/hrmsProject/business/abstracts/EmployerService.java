package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();
}
