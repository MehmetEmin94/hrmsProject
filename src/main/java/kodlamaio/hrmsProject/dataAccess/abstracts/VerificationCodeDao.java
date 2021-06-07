package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{

}
