package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerAuthService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value = "/api/jobseekerauth")
public class JobSeekerAuthController {

	private JobSeekerAuthService jobSeekerAuthService;

	@Autowired
	public JobSeekerAuthController(JobSeekerAuthService jobSeekerAuthService) {
		super();
		this.jobSeekerAuthService = jobSeekerAuthService;
	}
	
	@PostMapping(value = "/register")
	public Result register(@RequestBody JobSeeker jobSeeker,String confirmPassword) {
		return this.jobSeekerAuthService.register(jobSeeker, confirmPassword);
	}
}
