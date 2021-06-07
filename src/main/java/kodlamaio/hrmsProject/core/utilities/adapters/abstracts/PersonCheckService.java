package kodlamaio.hrmsProject.core.utilities.adapters.abstracts;

import java.time.LocalDate;

public interface PersonCheckService {

	boolean checkIfRealPerson(String tc,String firstName,String lastName,LocalDate birtDate);
}
