package com.softserve.edu.dashboard.tools;

import javax.servlet.http.HttpServletRequest;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.Messages;
import com.softserve.edu.dashboard.dto.UserDTO;

public class UserUtils {

	public static boolean isActiveSession(HttpServletRequest request) {
		return ((request.getSession().getAttribute(FieldName.USER_DTO) != null) ? true : false);
	}

	public static void createSession(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) request.getAttribute(FieldName.USER_DTO);
		if (isActiveSession(request)) {
			request.getSession().setAttribute(FieldName.USER_DTO, userDTO);
		} else {
			request.getSession(true).setAttribute(FieldName.USER_DTO, userDTO);
		}
// System.out.println("Session created for user " + userDTO.getLogin());
	}

	public static boolean isLogged(HttpServletRequest request) {
		String login = getStringParameter(request, FieldName.LOGIN);
		String password = getStringParameter(request, FieldName.PASSWORD);
		if (login != null && password != null) {
			if (Context.getInstance().getUserService().isLogged(login, password)) {
				UserDTO userDTO = Context.getInstance().getUserService().getUserDTO(login);
				request.setAttribute(FieldName.USER_DTO, userDTO);
				return true;
			} else {
				request.setAttribute(FieldName.MESSAGE, Messages.INVALID_LOGN);
				return false;
			}
		} else {
			request.setAttribute(FieldName.MESSAGE, Messages.INVALID_LOGN);
			return false;
		}
	}

	protected static String getStringParameter(HttpServletRequest request, String parameter) {
		if (request.getParameter(parameter) != null && !request.getParameter(parameter).isEmpty()) {
			return request.getParameter(parameter);
		} else {
			return null;
		}
	}

	public static UserDTO createUser(HttpServletRequest request) {
		if (!isActiveSession(request)) {
			if (isAllFieldsFilled(request)) {
				if (isPasswordsMatch(request)) {
					if (isLoginAvailable(request)) {
						UserDTO userDTO = new UserDTO(-1, request.getParameter(FieldName.NAME),
								request.getParameter(FieldName.LOGIN), request.getParameter(FieldName.PASSWORD),
								request.getParameter(FieldName.EMAIL));
						Context.getInstance().getUserService().setUserDTO(userDTO);
						request.setAttribute(FieldName.USER_DTO, userDTO);
						return userDTO;
					} else {
						request.setAttribute(FieldName.MESSAGE, Messages.LOGIN_UNAVAILABLE);
					}
				}
			}
		}
		return null;
	}

	public static UserDTO updateUser(HttpServletRequest request) {
		if (isActiveSession(request)) {
			String login = ((UserDTO) request.getSession().getAttribute(FieldName.USER_DTO)).getLogin();
			if (isAllFieldsFilled(request)) {
				if (isPasswordsMatch(request)) {
					UserDTO userDTO = new UserDTO(1, request.getParameter(FieldName.NAME), login,
							request.getParameter(FieldName.PASSWORD), request.getParameter(FieldName.EMAIL));
					Context.getInstance().getUserService().setUserDTO(userDTO);
					request.setAttribute(FieldName.USER_DTO, userDTO);
					return userDTO;
				}
			}
		}
		return null;
	}

	private static boolean isAllFieldsFilled(HttpServletRequest request) {
		String login = getStringParameter(request, FieldName.LOGIN);
		String name = getStringParameter(request, FieldName.NAME);
		String password = getStringParameter(request, FieldName.PASSWORD);
		String confirmpassword = getStringParameter(request, FieldName.CONFIRMPASSWORD);
		String email = getStringParameter(request, FieldName.EMAIL);

		UserDTO userDTO;
		if (isLoginAvailable(request)) {
			userDTO = new UserDTO(0, name, login, null, email);
		} else {
			userDTO = new UserDTO(0, name, null, null, email);
		}
		request.setAttribute(FieldName.USER_DTO, userDTO);
		if (login != null && name != null && password != null && password != null && confirmpassword != null
				&& email != null) {
			return true;
		} else {
			request.setAttribute(FieldName.MESSAGE, Messages.NOT_FILLED);
			return false;
		}
	}

	private static boolean isPasswordsMatch(HttpServletRequest request) {
		String password = getStringParameter(request, FieldName.PASSWORD);
		String confirmpassword = getStringParameter(request, FieldName.CONFIRMPASSWORD);
		if (password != null && confirmpassword != null && password.equals(confirmpassword)) {
			return true;
		} else {
			request.setAttribute(FieldName.MESSAGE, Messages.PASSWORDS_NOT_MATCH);
			return false;
		}
	}

	private static boolean isLoginAvailable(HttpServletRequest request) {
		if (isActiveSession(request)) {
			return true;
		} else {
			String login = getStringParameter(request, FieldName.LOGIN);
			if (login != null) {
				return (Context.getInstance().getUserService().isExistLogin(login) ? false : true);
			} else {
				return false;
			}
		}
	}

}
