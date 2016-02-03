package application.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.exception.UserNotFoundException;
import application.model.User;
import application.model.UserAuth;
import application.service.AuthenticationService;
import application.service.UserService;


@CrossOrigin
@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody UserAuth userAuth) throws UserNotFoundException {
		User authenticated = userService.findById(userService.findByUserAuth(userAuth));
		if (authenticated.getPassword().compareTo(userAuth.getPassword()) != 0
				|| authenticated.getUsername().compareTo(userAuth.getUsername()) != 0)
			throw new UserNotFoundException();

		try {
			return authenticationService.findToken(userAuth);
		} catch (UserNotFoundException e) {
			return authenticationService.create(userAuth).getToken();
		}

	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		return userService.create(user);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ResponseEntity<String> handleException(UserNotFoundException ex) {
		return new ResponseEntity<String>("User not found", HttpStatus.UNAUTHORIZED);
	}
}
