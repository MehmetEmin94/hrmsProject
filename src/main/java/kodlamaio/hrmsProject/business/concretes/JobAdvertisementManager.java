package kodlamaio.hrmsProject.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllByCreatedAt() {
		Sort sort=Sort.by(Sort.Direction.DESC,"createdAt");
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveTrueAndCreatedAt(sort));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(int userId) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrueAndUserId(userId));
	}

	@Override
	public Result changeIsActiveById(int id) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(id);
		if(jobAdvertisement.isActive()==false) {
			jobAdvertisement.setActive(true);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult();
		}
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

}
