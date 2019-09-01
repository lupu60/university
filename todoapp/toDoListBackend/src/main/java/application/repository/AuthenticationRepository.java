package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Authentication;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
	public Authentication findByIdUser(Long idUser);

	public Authentication findByToken(String token);
}
