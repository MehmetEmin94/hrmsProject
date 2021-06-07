package kodlamaio.hrmsProject.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private int id;
	
	private int userId;
	
	private String jobTitle;
	
	private String companyName;
	
	private int openPositions;
	
	private LocalDateTime applicationDeadline;
	
	private LocalDateTime createdAt;

}
