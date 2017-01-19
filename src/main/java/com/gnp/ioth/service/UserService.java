package com.gnp.ioth.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.exception.UserNotFoundException;
import com.gnp.ioth.model.User;

@Service
public interface UserService {
  List<User> getAllUsers();

  public User create(User user);

  public User delete(Long id) throws UserNotFoundException;;

  User getCurrentUser();

  User findById(Long id);
}
