package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.VerificationCodeService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrmsProject.entities.concretes.VerificationCode;
@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}
	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult();
	}

}
