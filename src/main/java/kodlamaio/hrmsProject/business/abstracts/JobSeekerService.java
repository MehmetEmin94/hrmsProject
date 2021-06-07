package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<JobSeeker> getById(int id);
}
