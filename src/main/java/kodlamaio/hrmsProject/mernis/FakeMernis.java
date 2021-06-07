package kodlamaio.hrmsProject.mernis;

import java.time.LocalDate;

public class FakeMernis {

	public boolean validatePerson(String tcNo,String firstName,String lastName,LocalDate birtDate) {
		if(tcNo.length()==11) {
		return true;
		}
		return false;
	}
	
}
