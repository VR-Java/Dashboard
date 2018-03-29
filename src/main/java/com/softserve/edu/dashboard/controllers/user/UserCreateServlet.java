package com.softserve.edu.dashboard.controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPaths;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPaths.USER_CREATE_SERVLET)
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet from UserProfileCreateServlet");
		request.getRequestDispatcher(WebPaths.USER_PROFILE_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost from UserProfileCreateServlet");
		UserDTO userDTO;
		if (UserUtils.isActiveSession(request)) {
			userDTO = UserUtils.updateUser(request);
			System.out.println("user updated");
		} else {
			userDTO = UserUtils.createUser(request);
		}
		if (userDTO != null) {
			UserUtils.createSession(request);
			request.setAttribute(FieldName.USER_DTO, userDTO);
			request.getRequestDispatcher(WebPaths.USER_ITEMS_SERVLET).forward(request, response);
		} else {
			request.getRequestDispatcher(WebPaths.USER_PROFILE_JSP).forward(request, response);
		}
	}

}
