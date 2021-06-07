package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobTitleService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobTitle;

@RestController
@RequestMapping(value = "/api/jobtitles")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@GetMapping(value="/getbyid")
	public DataResult<JobTitle> getById(@RequestParam("id") int id){
		return this.jobTitleService.getById(id);
	}
}
