package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
