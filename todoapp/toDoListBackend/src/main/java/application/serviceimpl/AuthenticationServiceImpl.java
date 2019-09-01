package application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.exception.UserNotFoundException;
import application.model.Authentication;
import application.model.UserAuth;
import application.repository.AuthenticationRepository;
import application.service.AuthenticationService;
import application.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationRepository authenticationRepository;

	@Autowired
	UserService userService;

	@Transactional
	@Override
	public Authentication create(UserAuth userAuth) throws UserNotFoundException {
		Authentication userAuthentication = new Authentication();
		userAuthentication.setIdUser(userService.findByUserAuth(userAuth));
		userAuthentication.setToken(new Integer(userAuth.getUsername().hashCode()).toString());
		authenticationRepository.save(userAuthentication);
		return userAuthentication;
	}

	@Transactional
	@Override
	public String findToken(UserAuth userAuth) throws UserNotFoundException {
		Authentication userAuthentication = authenticationRepository.findByIdUser(userService.findByUserAuth(userAuth));
		if (userAuthentication == null)
			throw new UserNotFoundException();
		return userAuthentication.getToken();
	}

	@Override
	public Long findToken(String token) throws UserNotFoundException {
		Authentication authentication = authenticationRepository.findByToken(token);

		if (authentication == null)
			throw new UserNotFoundException();

		return authentication.getIdUser();
	}

}
