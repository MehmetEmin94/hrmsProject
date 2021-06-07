package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.EmployerAuthService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;

@RestController
@RequestMapping(value = "/api/employerauth")
public class EmployerAuthController {

	private EmployerAuthService employerAuthService;

	@Autowired
	public EmployerAuthController(EmployerAuthService employerAuthService) {
		super();
		this.employerAuthService = employerAuthService;
	}
	
	@PostMapping(value = "/register")
	public Result register(@RequestBody Employer employer,String confirmPassword) {
		return this.employerAuthService.register(employer, confirmPassword);
	}
}
