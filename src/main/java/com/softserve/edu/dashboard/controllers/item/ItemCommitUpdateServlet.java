package com.softserve.edu.dashboard.controllers.item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.dashboard.constants.WebPath;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.tools.Context;
import com.softserve.edu.dashboard.tools.ItemUtils;
import com.softserve.edu.dashboard.tools.UserUtils;

@WebServlet(WebPath.ITEM_COMMIT_SERVLET)
public class ItemCommitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemCommitUpdateServlet() {
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
		if (UserUtils.isActiveSession(request)) {
			ItemDTO itemDTO = ItemUtils.initItemDTO(request);
			if (itemDTO != null) {
				Context.getInstance().getItemServise().setItemDTO(itemDTO);
				response.sendRedirect(WebPath.BASE + WebPath.USER_ITEMS_SERVLET);
			} else {
				response.sendRedirect(WebPath.BASE + WebPath.ITEM_EDIT_SERVLET);
				return;
			}
		} else {
			response.sendRedirect(WebPath.BASE + WebPath.LOGIN_SERVLET);
		}
	}

}
