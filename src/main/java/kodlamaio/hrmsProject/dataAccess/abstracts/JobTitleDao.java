package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

	boolean existsByJobTitle(String jobTitle);
	
	JobTitle findById(int id);
}
