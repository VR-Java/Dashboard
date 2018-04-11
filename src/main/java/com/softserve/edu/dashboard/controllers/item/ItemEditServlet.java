package com.softserve.edu.dashboard.controllers.item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.ItemUtils;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.ITEM_EDIT_SERVLET)
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemEditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
			ItemUtils.editItem(request);
			request.getRequestDispatcher(WebPath.ITEM_PROFILE_JSP).forward(request, response);
		} else {
			response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
