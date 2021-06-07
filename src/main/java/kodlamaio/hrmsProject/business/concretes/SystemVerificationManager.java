package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.SystemVerificationService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.SystemVerificationDao;
import kodlamaio.hrmsProject.entities.concretes.SystemVerification;
@Service
public class SystemVerificationManager implements SystemVerificationService{

	private SystemVerificationDao systemVerificationDao;
	@Autowired
	public SystemVerificationManager(SystemVerificationDao systemVerificationDao) {
		super();
		this.systemVerificationDao = systemVerificationDao;
	}
	@Override
	public Result add(SystemVerification systemVerification) {
		this.systemVerificationDao.save(systemVerification);
		return new SuccessResult();
	}

}
