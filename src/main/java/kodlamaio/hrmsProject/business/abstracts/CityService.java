package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
	DataResult<City> getById(int id);
	
	Result add(City city);
}
