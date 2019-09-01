package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.ToDoItem;
import application.model.User;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
	
	List<ToDoItem> findByUser(User user);
	
}
