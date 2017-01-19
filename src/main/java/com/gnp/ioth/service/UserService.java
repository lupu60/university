package com.gnp.ioth.service;


import java.util.List;

import com.gnp.ioth.exception.UserNotFoundException;
import com.gnp.ioth.model.User;

public interface UserService {
  List<User> getAllUsers();

  public User create(User user);

  public User delete(Long id) throws UserNotFoundException;;

  User getCurrentUser();

  User findById(Long id);
}
