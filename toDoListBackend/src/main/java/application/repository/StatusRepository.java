package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
