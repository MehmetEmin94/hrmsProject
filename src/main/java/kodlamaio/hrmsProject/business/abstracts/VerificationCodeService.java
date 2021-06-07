package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode verificationCode);
}
