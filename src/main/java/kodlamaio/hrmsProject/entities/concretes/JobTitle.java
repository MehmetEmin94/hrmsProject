package kodlamaio.hrmsProject.entities.concretes;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="job_titles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	@NotBlank
	@NotNull
	private String jobTitle;
	
	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name="is_active")
	@ColumnDefault(value = "true")
	private boolean isActive;
	
	@Column(name="is_delete", columnDefinition = "boolean default false")
	@ColumnDefault(value = "false")
	private boolean isDelete=false;
	
	
	  @OneToMany(mappedBy="jobTitle") 
	  private List<JobAdvertisement> jobAdvertisements;
	 
}