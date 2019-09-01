package application.service;

import java.util.List;

import application.exception.ToDoItemNotFound;
import application.model.ToDoItem;
import application.model.User;

public interface ToDoItemService {
	List<ToDoItem> getMyItems(User user);

	ToDoItem getItemById(Long id) throws ToDoItemNotFound;

	ToDoItem createToDoItem(ToDoItem toDoItem);

	ToDoItem updateItem(ToDoItem toDoItem) throws ToDoItemNotFound;

	ToDoItem deleteItem(Long idToDoItem) throws ToDoItemNotFound;
}
