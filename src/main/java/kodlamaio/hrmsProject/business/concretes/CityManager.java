package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.CityService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsProject.entities.concretes.City;
@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<City>(this.cityDao.findById(id));
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult();
	}

}
