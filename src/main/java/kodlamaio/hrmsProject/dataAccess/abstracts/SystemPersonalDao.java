package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.SystemPersonal;

public interface SystemPersonalDao extends JpaRepository<SystemPersonal, Integer>{

}
