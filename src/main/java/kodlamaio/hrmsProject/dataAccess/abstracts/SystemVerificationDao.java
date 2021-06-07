package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.SystemVerification;

public interface SystemVerificationDao extends JpaRepository<SystemVerification, Integer>{

}
