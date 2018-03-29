package com.softserve.edu.dashboard.controllers.item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.WebPaths;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPaths.ITEM_CANCEL_SERVLET)
public class ItemCancelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemCancelUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet from ItemProfileCancelUpdateServlet");

		if (UserUtils.isActiveSession(request)) {
			request.getRequestDispatcher(WebPaths.USER_ITEMS_SERVLET).forward(request, response);
		} else {
			request.getRequestDispatcher(WebPaths.LOGIN_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost from ItemProfileCancelUpdateServlet");
		doGet(request, response);
	}

}
