package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.exception.ToDoItemNotFound;
import application.model.ToDoItem;
import application.service.ToDoItemService;
import application.service.UserService;
@CrossOrigin
@RestController
public class ToDoListController {

	@Autowired
	ToDoItemService toDoItemService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/todoitems", produces = "application/json")
	public List<ToDoItem> getAllItems() {
		return toDoItemService.getMyItems(userService.getCurrentUser());
	}

	@RequestMapping(value = "/todoitem/{id}", method = RequestMethod.GET, produces = "application/json")
	public ToDoItem getItemById(@PathVariable(value = "id") Long id) throws ToDoItemNotFound {
		return toDoItemService.getItemById(id);
	}

	@RequestMapping(value = "/todoitem/create", method = RequestMethod.POST, produces = "application/json")
	public ToDoItem createItem(@RequestBody ToDoItem toDoItem) {
		return toDoItemService.createToDoItem(toDoItem);
	}

	@RequestMapping(value = "/todoitem/delete/{id}", method = RequestMethod.POST, produces = "application/json")
	public ToDoItem deleteIitem(@PathVariable("id") Long id) throws ToDoItemNotFound {
		return toDoItemService.deleteItem(id);
	}

	@RequestMapping(value = "/todoitem/update", method = RequestMethod.POST, produces = "application/json")
	public ToDoItem updateItem(@RequestBody ToDoItem toDoItem) throws ToDoItemNotFound {
		return toDoItemService.updateItem(toDoItem);
	}

	@ExceptionHandler(ToDoItemNotFound.class)
	public @ResponseBody ResponseEntity<String> handleItemNotFound(ToDoItemNotFound exception) {
		return new ResponseEntity<String>("To Do Item Not Found", HttpStatus.NOT_FOUND);
	}
}
