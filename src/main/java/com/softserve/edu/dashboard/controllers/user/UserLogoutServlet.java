package com.softserve.edu.dashboard.controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.LOGOUT_SERVLET)
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
			request.getSession().invalidate();
		}
		response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
