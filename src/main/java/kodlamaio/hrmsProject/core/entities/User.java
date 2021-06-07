package kodlamaio.hrmsProject.core.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	private boolean isActive=true;
	
	@Column(name="is_deleted", columnDefinition = "boolean default false" )
	@JsonIgnore
	private boolean isDelete=false;
	
	@CreationTimestamp
	@Column(name="created_at")
	private LocalDateTime createdAt;
}