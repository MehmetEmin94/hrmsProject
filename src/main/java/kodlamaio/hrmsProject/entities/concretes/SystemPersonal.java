package kodlamaio.hrmsProject.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import kodlamaio.hrmsProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="system_personals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false) 
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id") 

public class SystemPersonal extends User{
		
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;

}