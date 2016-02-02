package application.service;

import application.exception.UserNotFoundException;
import application.model.Authentication;
import application.model.UserAuth;


public interface AuthenticationService {

	public Authentication create(UserAuth userAuth) throws UserNotFoundException;

	public String findToken(UserAuth userAuth) throws UserNotFoundException;

	public Long findToken(String token) throws UserNotFoundException;
}
