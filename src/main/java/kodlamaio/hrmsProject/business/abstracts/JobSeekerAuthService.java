package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerAuthService {

	Result register(JobSeeker jobSeeker,String confirmPassword);
}
