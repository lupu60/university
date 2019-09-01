package application.service;

import java.util.List;

import application.exception.UserNotFoundException;
import application.model.User;
import application.model.UserAuth;

public interface UserService {
	List<User> getAllUsers();

	public User create(User user);

	public User delete(Long id) throws UserNotFoundException;

	public Long findByUserAuth(UserAuth userAuth) throws UserNotFoundException;

	User getCurrentUser();

	User findById(Long id);
}
