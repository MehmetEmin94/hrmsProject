package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.CityService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.City;

@RestController
@RequestMapping(value = "/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<City> getById(int id){
		return this.cityService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
}
