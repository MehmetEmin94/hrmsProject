package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value = "/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;
@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<JobSeeker> getById(int id){
		return this.jobSeekerService.getById(id);
	}

}
