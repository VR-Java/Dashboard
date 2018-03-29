package com.softserve.edu.dashboard.tools;

import javax.servlet.http.HttpServletRequest;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.constants.Messages;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.dto.UserDTO;

public class ItemUtils {

	public static ItemDTO initItemDTO(HttpServletRequest request) {
		String login = ((UserDTO) request.getSession().getAttribute(FieldName.USER_DTO)).getLogin();
		UserDTO userDTO = Context.getInstance().getUserService().getUserDTO(login);
		Long userId = userDTO.getId();

		ItemDTO itemDTO = null;
		Long idItem;
		if (request.getSession().getAttribute(FieldName.ID_ITEM) != null
				&& !request.getSession().getAttribute(FieldName.ID_ITEM).toString().isEmpty()) {
			idItem = Long.parseLong(request.getSession().getAttribute(FieldName.ID_ITEM).toString());
			itemDTO = Context.getInstance().getItemServise().getItemDTO(idItem);
		} else {
			idItem = -1L;
		}

		String title = checkTitle(request, itemDTO);
		String description = checkDescription(request, itemDTO);
		String status = checkStatus(request, itemDTO);

		if (title != null && description != null && status != null) {
			return new ItemDTO(idItem, title, description, userId, status);
		} else {
			request.setAttribute(FieldName.MESSAGE, Messages.NOT_FILLED);
			return null;
		}
	}

	private static String checkTitle(HttpServletRequest request, ItemDTO itemDTO) {
		if (request.getParameter(FieldName.TITLE) != null && !request.getParameter(FieldName.TITLE).isEmpty()) {
			return request.getParameter(FieldName.TITLE);
		} else if ((String) request.getAttribute(FieldName.TITLE) != null
				&& !((String) request.getAttribute(FieldName.TITLE)).isEmpty()) {
			return (String) request.getAttribute(FieldName.TITLE);
		} else if (itemDTO != null) {
			return itemDTO.getTitle();
		} else {
			return null;
		}
	}

	private static String checkDescription(HttpServletRequest request, ItemDTO itemDTO) {
		if (request.getParameter(FieldName.DESCRIPTION) != null
				&& !request.getParameter(FieldName.DESCRIPTION).isEmpty()) {
			return request.getParameter(FieldName.DESCRIPTION);
		} else if ((String) request.getAttribute(FieldName.DESCRIPTION) != null
				&& !((String) request.getAttribute(FieldName.DESCRIPTION)).isEmpty()) {
			return (String) request.getAttribute(FieldName.DESCRIPTION);
		} else if (itemDTO != null) {
			return itemDTO.getDescription();
		} else {
			return null;
		}
	}

	private static String checkStatus(HttpServletRequest request, ItemDTO itemDTO) {
		if (request.getParameter(FieldName.STATUS) != null && !request.getParameter(FieldName.STATUS).isEmpty()) {
			return request.getParameter(FieldName.STATUS);
		} else if ((String) request.getAttribute(FieldName.STATUS) != null
				&& !((String) request.getAttribute(FieldName.STATUS)).isEmpty()) {
			return (String) request.getAttribute(FieldName.STATUS);
		} else if (itemDTO != null) {
			return itemDTO.getStatus();
		} else {
			return null;
		}
	}
}
