package com.softserve.edu.dashboard.controllers.item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.WebPaths;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.ItemUtils;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPaths.ITEM_COMMIT_SERVLET)
public class ItemCommitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemCommitUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet from ItemProfileCommitUpdateServlet");
		if (UserUtils.isActiveSession(request)) {
			request.getRequestDispatcher(WebPaths.ITEM_PROFILE_JSP).forward(request, response);
		} else {
			request.getRequestDispatcher(WebPaths.LOGIN_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost from ItemProfileCommitUpdateServlet");
		if (UserUtils.isActiveSession(request)) {
			ItemDTO itemDTO = ItemUtils.initItemDTO(request);
			if (itemDTO != null) {
				Context.getInstance().getItemServise().setItemDTO(itemDTO);
				request.getRequestDispatcher(WebPaths.USER_ITEMS_SERVLET).forward(request, response);
			} else {
				request.getRequestDispatcher(WebPaths.ITEM_PROFILE_JSP).forward(request, response);
				return;
			}
		} else {
			request.getRequestDispatcher(WebPaths.LOGIN_SERVLET).forward(request, response);
		}
	}

}
