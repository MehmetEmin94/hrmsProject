package kodlamaio.hrmsProject.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import kodlamaio.hrmsProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Table(name = "job_seekers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) 
public class JobSeeker extends User{

	
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="national_id")
	@NotBlank
	@NotNull
	private String nationalId;
	
	@Column(name="birth_date")
	@NotBlank
	@NotNull
	private LocalDate birthDate;
	
	@Column(name="is_verified")
	@NotBlank
	@NotNull
	@ColumnDefault(value = "false")
	private boolean isVerified;
	
}

