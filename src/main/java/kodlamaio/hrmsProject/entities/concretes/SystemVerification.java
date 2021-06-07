package kodlamaio.hrmsProject.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="system_verifications")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SystemVerification{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employer_id")
	@NotBlank
	@NotNull
	private int employerId;
	
	@Column(name = "is_verified")
	@NotBlank
	@NotNull
	@ColumnDefault(value = "false")
	private boolean isVerified;
	
	@Column(name = "created_at")
	@CreationTimestamp
	@NotBlank
	@NotNull
	private LocalDateTime createAt;
}
