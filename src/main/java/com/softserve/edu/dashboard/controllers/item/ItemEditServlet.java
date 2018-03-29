package com.softserve.edu.dashboard.controllers.item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.WebPaths;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPaths.ITEM_EDIT_SERVLET)
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemEditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet from ItemProfileEditServlet");
		if (UserUtils.isActiveSession(request)) {
			if (request.getParameter(FieldName.ID_ITEM) != null
					&& !request.getParameter(FieldName.ID_ITEM).isEmpty()) {
				Long idItem = Long.parseLong(request.getParameter(FieldName.ID_ITEM));
				ItemDTO itemDTO = Context.getInstance().getItemServise().getItemDTO(idItem);
				request.setAttribute(FieldName.ITEM_DTO, itemDTO);
				request.getSession().setAttribute(FieldName.ID_ITEM, idItem);
			}
			request.getRequestDispatcher(WebPaths.ITEM_PROFILE_JSP).forward(request, response);
		} else {
			request.getRequestDispatcher(WebPaths.LOGIN_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost from ItemProfileEditServlet");
		doGet(request, response);
	}

}
