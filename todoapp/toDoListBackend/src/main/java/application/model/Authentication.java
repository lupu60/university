package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authentication")
public class Authentication {
	@Id
	@GeneratedValue
	@Column(name = "idAuthentication")
	Long id;

	@Column(name = "idUser", nullable = true)
	Long idUser;

	@Column(name = "token", nullable = false)
	String token;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

}