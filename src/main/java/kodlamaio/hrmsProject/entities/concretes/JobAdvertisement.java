package kodlamaio.hrmsProject.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*
	 * @Column(name="employer_id") private int employerId;
	 * 
	 * @Column(name = "city_id") private int cityId;
	 * 
	 * @Column(name = "job_title_id") private int jobTitleId;
	 */
	
	  @ManyToOne()
	  @JoinColumn(name = "employer_id") 
	  private Employer employer;
	  
	  @ManyToOne()
	  @JoinColumn(name = "job_title_id") 
	  private JobTitle jobTitle;
	  
	  @ManyToOne()
	  @JoinColumn(name = "city_id") 
	  private City city;
	 
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;
	
	@Column(name = "min_salary")
	@NotBlank
	@NotNull
	private int minSalary;
	
	@Column(name="max_salary")
	@NotBlank
	@NotNull
	private int maxSalary;
	
	@Column(name="open_positions")
	@NotBlank
	@NotNull
	private int openPositions;
	
	@Column(name="application_deadline")
	@NotBlank
	@NotNull
	private LocalDateTime applicationDeadline;
	
	
	
	@Column(name="is_deleted")
	@ColumnDefault(value = "false")
	private boolean isDeleted;
	
	@Column(name="created_at")
	@CreationTimestamp
	@NotBlank
	@NotNull
	private LocalDateTime createdAt;
}
