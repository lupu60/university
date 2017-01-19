package com.gnp.ioth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.User;
import com.gnp.ioth.service.UserService;


@CrossOrigin
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/profile", produces = "application/json")
  public ResponseEntity<?> getMyDetails() {
    List<User> authenticatedUser = userService.getAllUsers();
    return ResponseEntity.ok(authenticatedUser);
  }

  @RequestMapping(value = "/createUser", method = RequestMethod.POST)
  public @ResponseBody User createUser(@RequestBody User user) {
      return userService.create(user);
  }

}

