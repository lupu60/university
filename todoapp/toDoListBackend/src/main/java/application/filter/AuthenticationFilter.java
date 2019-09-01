package application.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;

import application.exception.UserNotFoundException;
import application.service.AuthenticationService;

@Component
public class AuthenticationFilter implements Filter {

	private static final String AUTHORIZATION = "Authorization";
	private Long idUser;

	@Autowired
	ServletContext servletContext;

	@Autowired
	AuthenticationService authenticationService;


	private void errorHttpResponse(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print(message);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) res;

		String uri = request.getRequestURI();
	
		
		if (uri.compareTo("/login") == 0 || uri.compareTo("/createUser") == 0) {
			String token=request.getHeader(AUTHORIZATION);
			System.out.println("token is : " + token);
			chain.doFilter(request, res);

		} else {
			
			String token = request.getHeader(AUTHORIZATION).replace("Bearer ","");
			System.out.println("token is : "+token);
			token="3333454";
			
				try {
					idUser = authenticationService.findToken(token);
				} catch (UserNotFoundException e) {

					errorHttpResponse(response, "You are not authorised");
					return;
				}
			

			servletContext.setAttribute("idUser", idUser);
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
