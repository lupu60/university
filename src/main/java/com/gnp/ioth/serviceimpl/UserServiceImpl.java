package com.gnp.ioth.serviceimpl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gnp.ioth.exception.UserNotFoundException;
import com.gnp.ioth.model.User;
import com.gnp.ioth.repository.UserRepository;
import com.gnp.ioth.service.UserService;



public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  private ServletContext servletContext;

  @Override
  public List<User> getAllUsers() {

    return userRepository.findAll();

  }

  @Transactional
  @Override
  public User findById(Long id) {
    User foundUser = userRepository.findOne(id);
    return foundUser;
  }


  @Override
  public User getCurrentUser() {
    return findById((Long) servletContext.getAttribute("idUser"));
  }

  @Transactional
  @Override
  public User create(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  @Transactional(rollbackFor = UserNotFoundException.class)
  public User delete(Long id) throws UserNotFoundException {
    User deletedUser = userRepository.findOne(id);
    if (deletedUser == null)
      throw new UserNotFoundException();
    userRepository.delete(deletedUser);
    return deletedUser;
  }


}
