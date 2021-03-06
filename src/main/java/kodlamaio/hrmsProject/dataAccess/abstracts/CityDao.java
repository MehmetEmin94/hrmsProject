package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City findById(int id);
}
