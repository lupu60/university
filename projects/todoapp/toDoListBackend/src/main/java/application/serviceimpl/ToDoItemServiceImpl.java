package application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.exception.ToDoItemNotFound;
import application.model.ToDoItem;
import application.model.User;
import application.repository.ToDoItemRepository;
import application.service.ToDoItemService;
import application.service.UserService;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

	@Autowired
	ToDoItemRepository toDoItemRepository;

	@Autowired
	UserService userService;

	@Override
	public List<ToDoItem> getMyItems(User user) {
		return toDoItemRepository.findByUser(user);
	}

	@Override
	@Transactional
	public ToDoItem createToDoItem(ToDoItem toDoItem) {
		toDoItem.setUser(userService.getCurrentUser());
		return toDoItemRepository.save(toDoItem);
	}

	@Override
	@Transactional
	public ToDoItem updateItem(ToDoItem toDoItem) throws ToDoItemNotFound {
		ToDoItem dbItem = toDoItemRepository.findOne(toDoItem.getId());
		if (dbItem == null)
			throw new ToDoItemNotFound();
		return toDoItemRepository.save(toDoItem);
	}

	@Override
	public ToDoItem deleteItem(Long idToDoItem) throws ToDoItemNotFound {
		ToDoItem dbItem = toDoItemRepository.findOne(idToDoItem);
		if (dbItem == null)
			throw new ToDoItemNotFound();
		toDoItemRepository.delete(dbItem);
		return dbItem;
	}

	@Override
	public ToDoItem getItemById(Long id) throws ToDoItemNotFound {
		ToDoItem dbItem = toDoItemRepository.findOne(id);
		if (dbItem == null)
			throw new ToDoItemNotFound();
		return dbItem;
	}

}
