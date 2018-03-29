package com.softserve.edu.dashboard.constants;

public class WebPaths {
	
	// JSP files
	public static final String USER_ITEMS_JSP = "/WEB-INF/views/commons/UserItems.jsp"; //WebPaths.USER_ITEMS_JSP
	public static final String LOGIN_JSP = "/WEB-INF/views/users/Login.jsp"; //WebPaths.LOGIN_JSP
	public static final String ITEM_PROFILE_JSP = "/WEB-INF/views/items/ItemProfile.jsp"; //WebPaths.ITEM_PROFILE_JSP
	public static final String USER_PROFILE_JSP = "/WEB-INF/views/users/UserProfile.jsp"; //WebPaths.USER_PROFILE_JSP
	
	// *** Servlets ***
	// common Servlets
	public static final String HOME_SERVLET = "/"; //WebPaths.HOME_SERVLET
	public static final String USER_ITEMS_SERVLET = "/useritems"; //WebPaths.USER_ITEMS_SERVLET
	
	// user Servlets
	public static final String LOGIN_SERVLET = "/login"; //WebPaths.LOGIN_SERVLET
	public static final String LOGOUT_SERVLET = "/logout"; //WebPaths.LOGOUT_SERVLET
	public static final String USER_CANCEL_SERVLET = "/usercancel"; //WebPaths.USER_CANCEL_SERVLET
	public static final String USER_COMMIT_SERVLET = "/usercommit"; //WebPaths.USER_COMMIT_SERVLET
	public static final String USER_CREATE_SERVLET = "/usercreate"; //WebPaths.USER_CREATE_SERVLET

	// item Servlets
	public static final String ITEM_COMMIT_SERVLET = "/itemcommit"; //WebPaths.ITEM_COMMIT_SERVLET
	public static final String ITEM_CANCEL_SERVLET = "/itemcancel"; //WebPaths.ITEM_CANCEL_SERVLET
	public static final String ITEM_CREATE_SERVLET = "/itemcreate"; //WebPaths.ITEM_CREATE_SERVLET
	public static final String ITEM_EDIT_SERVLET = "/itemedit"; //WebPaths.ITEM_EDIT_SERVLET
	public static final String ITEM_DELETE_SERVLET = "/itemdelete"; //WebPaths.ITEM_DELETE_SERVLET
}
