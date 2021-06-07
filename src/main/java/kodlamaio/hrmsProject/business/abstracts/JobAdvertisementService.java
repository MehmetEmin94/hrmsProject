package kodlamaio.hrmsProject.business.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	Result changeIsActiveById(int id);
	
	DataResult<List<JobAdvertisementDto>> getAllIsActive();
	
	DataResult<List<JobAdvertisementDto>> getAllByCreatedAt();
	
	DataResult<List<JobAdvertisementDto>> getByCompanyName(int userId);
}
