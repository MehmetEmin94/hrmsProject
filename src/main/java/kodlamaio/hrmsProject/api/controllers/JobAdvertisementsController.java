package kodlamaio.hrmsProject.api.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping(value = "/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
    @Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

    @PostMapping(value = "/add")
     public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	 return this.jobAdvertisementService.add(jobAdvertisement);
     }

     @GetMapping("/getallisactive")
     public DataResult<List<JobAdvertisementDto>> getAllIsActive(){
	 return this.jobAdvertisementService.getAllIsActive();
     }
     
     @GetMapping("/findbycreatedfirst")
     public DataResult<List<JobAdvertisementDto>> getAllByCreatedAt(){
	 return this.jobAdvertisementService.getAllByCreatedAt();
     }
     @GetMapping("/getbycompanyname")
     public DataResult<List<JobAdvertisementDto>> getByCompanyName(@RequestParam int userId) {
 		
 		return this.jobAdvertisementService.getByCompanyName(userId);
 	}
     @PostMapping("changeisactivebyid")
     public Result changeIsActiveById(int id) {
    	 return this.jobAdvertisementService.changeIsActiveById(id);
     }
}
