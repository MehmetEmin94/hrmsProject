package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{


	@Query("Select new kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto(a.id,e.id,t.jobTitle, e.companyName, a.openPositions,a.applicationDeadline,a.createdAt) From JobAdvertisement a Inner Join a.employer e Inner Join a.jobTitle t")
	List<JobAdvertisementDto> findByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto(a.id,e.id,t.jobTitle, e.companyName, a.openPositions,a.applicationDeadline,a.createdAt) From JobAdvertisement a Inner Join a.employer e Inner Join a.jobTitle t")
	List<JobAdvertisementDto> findByIsActiveTrueAndCreatedAt(Sort sort);
	
	@Query("Select new kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto(a.id,e.id,t.jobTitle, e.companyName, a.openPositions,a.applicationDeadline,a.createdAt) From JobAdvertisement a Inner Join a.employer e Inner Join a.jobTitle t")
	List<JobAdvertisementDto> getByIsActiveTrueAndUserId(int userId);
	
	
	
}
