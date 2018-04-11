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

@WebServlet(WebPath.ITEM_CREATE_SERVLET)
public class ItemCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemCreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
				request.getRequestDispatcher(WebPath.ITEM_PROFILE_JSP).forward(request, response);
		} else {
			response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UserUtils.isActiveSession(request)) {
			ItemDTO itemDTO = ItemUtils.initItemDTO(request);
			if (itemDTO != null) {
				Context.getInstance().getItemServise().setItemDTO(itemDTO);
				request.getSession().setAttribute(FieldName.ID_ITEM, null);
				response.sendRedirect(WebPath.BASE + WebPath.USER_ITEMS_SERVLET);
				return;
			}
		}
		doGet(request, response);
	}

}
