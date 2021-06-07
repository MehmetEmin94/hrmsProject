package kodlamaio.hrmsProject.entities.concretes;


import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
@Table(name = "employers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) 
@Inheritance(strategy = InheritanceType.JOINED)
public class Employer extends User{

	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "web_adress")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name = "is_verified")
	@NotBlank
	@NotNull
	@ColumnDefault(value = "false")
	private boolean isVerified;
	
	
	  @OneToMany(mappedBy = "employer") 
	  private List<JobAdvertisement> jobAdvertisements;
	 
}
