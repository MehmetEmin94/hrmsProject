package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.Employer;

@RestController
@RequestMapping(value = "/api/employers")
public class EmployersController {
	private EmployerService employerService;
@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}

}
