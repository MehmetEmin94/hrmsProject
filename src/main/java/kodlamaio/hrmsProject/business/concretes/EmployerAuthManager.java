package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerAuthService;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.abstracts.SystemVerificationService;
import kodlamaio.hrmsProject.business.abstracts.VerificationCodeService;
import kodlamaio.hrmsProject.core.dataAccess.UserDao;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.utilities.verificationByMail.VerificationByMailService;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.SystemVerification;
import kodlamaio.hrmsProject.entities.concretes.VerificationCode;

@Service
public class EmployerAuthManager implements EmployerAuthService{

	private EmployerService employerService;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private SystemVerificationService systemVerificationService;
	private VerificationByMailService verificationByMailService;
	@Autowired
	public EmployerAuthManager(EmployerService employerService,UserDao userDao,VerificationCodeService verificationCodeService,
			VerificationByMailService verificationByMailService,SystemVerificationService systemVerificationService) {
		super();
		this.employerService = employerService;
		this.userDao=userDao;
		this.verificationCodeService=verificationCodeService;
		this.verificationByMailService=verificationByMailService;
		this.systemVerificationService=systemVerificationService;
	}
	@Override
	public Result register(Employer employer, String confirmPassword) {
		if (isEmpty(employer)==false) {
			return new ErrorResult("Please do not leave blank spaces");
		}
		if(checkPasswordTrue(employer.getPassword(), confirmPassword)==false) {
			return new ErrorResult("Please enter same password");
		}
		if(this.userDao.existsByEmail(employer.getEmail())==true) {
			return new ErrorResult("this person is already exist.Please try another email.");
		}
		if(isEmailSameWebDomain(employer.getEmail(),employer.getWebsite())==false) {
			return new ErrorResult("this email is not valid for web adress");
		}
		employerService.add(employer);
		String code=verificationByMailService.sendCode();
		verificationCodeSave(code, employer.getId(), employer.getEmail());
		verifyBySystemPersonel(employer.getId());
		return new SuccessResult();
	}
	
	public void verifyBySystemPersonel(int id) {
		SystemVerification systemVerification=new SystemVerification();
		systemVerification.setEmployerId(id);
		systemVerification.setVerified(true);
		this.systemVerificationService.add(systemVerification);
	}
	public void verificationCodeSave(String code,int id,String email) {
		VerificationCode verificationCode=new VerificationCode();
		verificationCode.setUserId(id);
		verificationCode.setVerificationCode(code);
		verificationCode.setVerified(true);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	}
	
	public boolean isEmailSameWebDomain(String email,String website) {
		
		String[] emailArr=email.split("@",2);
		String webAdress=website.substring(4,website.length());
		if(emailArr[1].equals(webAdress)) {
			return true;
		}
		return false;
		
	}
	public boolean checkPasswordTrue(String password,String confirmPassword) {
		if(password.equals(confirmPassword)) {
			return true;
		}return false;
	}
	
	
	public boolean isEmpty(Employer employer) {
		if(employer != null&&employer.getCompanyName()!=null&& employer.getWebsite()!=null &&
				employer.getPhoneNumber()!=null&&  employer.getEmail()!=null&& 
						employer.getPassword()!=null) {
			
			return true;
		}else{return false;
		}	
		}

}
