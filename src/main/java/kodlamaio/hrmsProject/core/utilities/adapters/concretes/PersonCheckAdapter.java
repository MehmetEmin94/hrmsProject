package kodlamaio.hrmsProject.core.utilities.adapters.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.utilities.adapters.abstracts.PersonCheckService;
import kodlamaio.hrmsProject.mernis.FakeMernis;
@Service
public class PersonCheckAdapter implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(String tcNo, String firstName, String lastName, LocalDate birtDate) {
		FakeMernis fakeMernis=new FakeMernis();
		if(fakeMernis.validatePerson(tcNo, firstName, lastName, birtDate)==true) {
			return true;
		}return false;
		
		
	}

}
