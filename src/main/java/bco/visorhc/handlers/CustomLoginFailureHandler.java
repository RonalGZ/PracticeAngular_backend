package bco.visorhc.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		if (exception instanceof BadCredentialsException) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding("UTF-8");
			JSONObject jsonResponse = new JSONObject();
			//jsonResponse.put("message", "Contraseña Incorrecta");
			jsonResponse.put("message", "Existe un error en su password o usuario");
			response.getWriter().write(jsonResponse.toString());
		}
		if (exception instanceof LockedException) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding("UTF-8");
			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("message", "Usuario Bloqueado");
			response.getWriter().write(jsonResponse.toString());
		}
		if (exception instanceof DisabledException) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding("UTF-8");
			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("message", "Usuario Deshabilitado");
			response.getWriter().write(jsonResponse.toString());
		}
		if (exception instanceof UsernameNotFoundException) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding("UTF-8");
			JSONObject jsonResponse = new JSONObject();
			//jsonResponse.put("message", "Usuario incorrecto");
			jsonResponse.put("message", "Existe un error en su password o usuario");
			response.getWriter().write(jsonResponse.toString());
		}
	}

}
