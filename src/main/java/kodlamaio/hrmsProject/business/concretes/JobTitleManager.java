package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobTitleService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrmsProject.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}
	@Override
	public Result add(JobTitle jobTitle) {
		if(this.jobTitleDao.existsByJobTitle(jobTitle.getJobTitle())==true) {
			return new ErrorResult("This title already exist.Please enter another.");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult();
	}
	@Override
	public DataResult<JobTitle> getById(int id) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findById(id));
	}

}
