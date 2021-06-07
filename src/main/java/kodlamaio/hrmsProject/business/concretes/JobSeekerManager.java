package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.entities.User;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}
	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}
	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id));
	}
	
}
