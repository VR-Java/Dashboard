package com.softserve.edu.dashboard.controllers.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.USER_COMMIT_SERVLET)
public class UserCommitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCommitUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
			response.sendRedirect(WebPath.BASE + WebPath.USER_ITEMS_SERVLET);
		} else {
			response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
