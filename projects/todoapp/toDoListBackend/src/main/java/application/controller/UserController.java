package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.User;
import application.service.UserService;
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/profile", produces = "application/json")
	public ResponseEntity<?> getMyDetails() {
		User authenticatedUser = userService.getCurrentUser();
		return ResponseEntity.ok(authenticatedUser);
	}
	
	
}
