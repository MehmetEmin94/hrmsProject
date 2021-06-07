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

@Entity
@Table(name="verification_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "user_id")
	@NotBlank
	@NotNull
	private int userId;
	
	@Column(name = "verification_code")
	@NotBlank
	@NotNull
	private String verificationCode;
	
	@Column(name = "is_verified")
	@NotBlank
	@NotNull
	@ColumnDefault(value = "false")
	private boolean isVerified;
	
	@Column(name = "created_at")
	@NotBlank
	@NotNull
	@CreationTimestamp
	private LocalDateTime createdAt;
}

