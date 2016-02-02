package application.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import application.exception.UserNotFoundException;
import application.service.AuthenticationService;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	private static final String AUTHORIZATION = "Authorization";
	private Long idUser;

	@Autowired
	ServletContext servletContext;

	@Autowired
	AuthenticationService authenticationService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.compareTo("/login") == 0 || uri.compareTo("/createUser") == 0) {

			filterChain.doFilter(request, response);

		} else {
			String token = request.getHeader(AUTHORIZATION);

			if (token == null) {
				errorHttpResponse(response, "You are not logged in");
				return;
			} else {
				try {
					idUser = authenticationService.findToken(token);
				} catch (UserNotFoundException e) {

					errorHttpResponse(response, "You are not authorised");
					return;
				}
			}

			servletContext.setAttribute("idUser", idUser);
			filterChain.doFilter(request, response);
		}
	}

	private void errorHttpResponse(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print(message);
	}

}
