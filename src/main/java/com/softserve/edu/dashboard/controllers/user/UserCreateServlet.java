package com.softserve.edu.dashboard.controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.USER_CREATE_SERVLET)
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(WebPath.USER_PROFILE_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO;
		if (UserUtils.isActiveSession(request)) {
			userDTO = UserUtils.updateUser(request);
		} else {
			userDTO = UserUtils.createUser(request);
		}
		if (userDTO != null) {
			UserUtils.createSession(request);
			request.setAttribute(FieldName.USER_DTO, userDTO);
			response.sendRedirect(WebPath.BASE + WebPath.USER_ITEMS_SERVLET);
		} else {
			doGet(request, response);
//			request.getRequestDispatcher(WebPath.USER_PROFILE_JSP).forward(request, response);
		}
	}

}
