package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}
	

}
