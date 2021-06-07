package kodlamaio.hrmsProject.core.utilities.verificationByMail;

public interface VerificationByMailService {

	void sendLink(String email);
	String sendCode();
}
