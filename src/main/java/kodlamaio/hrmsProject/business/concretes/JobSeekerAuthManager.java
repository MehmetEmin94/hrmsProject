package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerAuthService;
import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.abstracts.VerificationCodeService;
import kodlamaio.hrmsProject.core.dataAccess.UserDao;
import kodlamaio.hrmsProject.core.utilities.adapters.abstracts.PersonCheckService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.utilities.verificationByMail.VerificationByMailService;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.VerificationCode;
@Service
public class JobSeekerAuthManager implements JobSeekerAuthService{

	private JobSeekerService jobSeekerService;
	private JobSeekerDao jobSeekerDao;
	private PersonCheckService personCheckService;
	private UserDao userDao;
	private VerificationByMailService verificationByMailService;
	private VerificationCodeService verificationCodeService;
	@Autowired
	public JobSeekerAuthManager(JobSeekerService jobSeekerService,PersonCheckService personCheckService,
			JobSeekerDao jobSeekerDao,UserDao userDao,VerificationByMailService verificationByMailService,VerificationCodeService verificationCodeService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.personCheckService=personCheckService;
		this.jobSeekerDao=jobSeekerDao;
		this.userDao=userDao;
		this.verificationByMailService=verificationByMailService;
		this.verificationCodeService=verificationCodeService;
	}
	@Override
	public Result register(JobSeeker jobSeeker, String confirmPassword) {
		if(isEmpty(jobSeeker)==false){
			 return new ErrorResult("Please do not leave blank spaces");
		}
		if(checkPasswordTrue(jobSeeker.getPassword(), confirmPassword)==false) {
			return new ErrorResult("Please enter same password");
		}
		if(this.personCheckService.checkIfRealPerson(jobSeeker.getNationalId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthDate())==false) {
			 return new ErrorResult("This person is not valid");
		}
		if(this.jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())==true) {
			return new ErrorResult("This person is already exist.Please try another nationality Number.");
		}
		if(this.userDao.existsByEmail(jobSeeker.getEmail())==true) {
			return new ErrorResult("this person is already exist.Please try another email.");
		}
		jobSeekerService.add(jobSeeker);
		String code=verificationByMailService.sendCode();
		verificationCodeSave(code, jobSeeker.getId(), jobSeeker.getEmail());
		return new SuccessResult();
		
	}
	
	public void verificationCodeSave(String code,int id,String email) {
		VerificationCode verificationCode=new VerificationCode();
		verificationCode.setUserId(id);
		verificationCode.setVerificationCode(code);
		verificationCode.setVerified(false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	}
	
	public boolean isEmpty(JobSeeker jobSeeker) {
		if(jobSeeker != null&&jobSeeker.getFirstName()!=null&& jobSeeker.getLastName()!=null &&
				jobSeeker.getNationalId()!=null&& jobSeeker.getBirthDate()!=null&& jobSeeker.getEmail()!=null&& 
				jobSeeker.getPassword()!=null) {
			
			return true;
		}else{return false;
		}	
		}
	public boolean checkPasswordTrue(String password,String confirmPassword) {
		if(password.equals(confirmPassword)) {
			return true;
		}return false;
	}

}
