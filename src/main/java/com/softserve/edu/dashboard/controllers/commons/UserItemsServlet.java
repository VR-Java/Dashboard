package com.softserve.edu.dashboard.controllers.commons;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPaths;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.dto.UserItemsDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPaths.USER_ITEMS_SERVLET)
public class UserItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserItemsServlet() {
		super();
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet from UserItemsServlet");
		request.getHeader("useritmes");
		
		if (UserUtils.isActiveSession(request)) {
			UserDTO userDTO = (UserDTO) request.getSession().getAttribute(FieldName.USER_DTO);
			if (userDTO != null) {
				UserItemsDTO userItemsDTO = Context.getInstance().getUserItemsServise().getUserItems(userDTO);
				request.setAttribute(FieldName.USER_ITEMS_DTO, userItemsDTO);
				
				request.getRequestDispatcher(WebPaths.USER_ITEMS_JSP).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(WebPaths.LOGIN_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost from UserItemsServlet");
		
//		if(UserUtils.isActiveSession(request)) {
//			response.sendRedirect(WebPaths.USER_ITEMS_SERVLET);
//		} else {
//			response.sendRedirect(WebPaths.LOGIN_SERVLET);
//		}
//		
		doGet(request, response);
	}

}
