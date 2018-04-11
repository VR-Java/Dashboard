package com.softserve.edu.dashboard.controllers.commons;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.dto.UserItemsDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.USER_ITEMS_SERVLET)
public class UserItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserItemsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
			UserDTO userDTO = (UserDTO) request.getSession().getAttribute(FieldName.USER_DTO);
			UserItemsDTO userItemsDTO = Context.getInstance().getUserItemsServise().getUserItems(userDTO);
			request.setAttribute(FieldName.USER_ITEMS_DTO, userItemsDTO);
			request.getRequestDispatcher(WebPath.USER_ITEMS_JSP).forward(request, response);
		} else {
			response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
