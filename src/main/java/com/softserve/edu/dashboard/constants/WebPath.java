package com.softserve.edu.dashboard.constants;

public class WebPath {
	
	// JSP files
	public static final String USER_ITEMS_JSP = "/WEB-INF/views/commons/UserItems.jsp"; //WebPath.USER_ITEMS_JSP
	public static final String LOGIN_JSP = "/WEB-INF/views/users/Login.jsp"; //WebPath.LOGIN_JSP
	public static final String ITEM_PROFILE_JSP = "/WEB-INF/views/items/ItemProfile.jsp"; //WebPath.ITEM_PROFILE_JSP
	public static final String USER_PROFILE_JSP = "/WEB-INF/views/users/UserProfile.jsp"; //WebPath.USER_PROFILE_JSP
	
	// *** Servlets ***
	// common Servlets
	public static final String BASE = "/Dashboard"; //WebPath.BASE
	public static final String HOME_SERVLET = "/"; //WebPath.HOME_SERVLET
	public static final String USER_ITEMS_SERVLET = "/useritems"; //WebPath.USER_ITEMS_SERVLET
	
	// user Servlets
	public static final String LOGIN_SERVLET = "/login"; //WebPath.LOGIN_SERVLET
	public static final String LOGOUT_SERVLET = "/logout"; //WebPath.LOGOUT_SERVLET
	public static final String USER_CANCEL_SERVLET = "/usercancel"; //WebPath.USER_CANCEL_SERVLET
	public static final String USER_COMMIT_SERVLET = "/usercommit"; //WebPath.USER_COMMIT_SERVLET
	public static final String USER_CREATE_SERVLET = "/usercreate"; //WebPath.USER_CREATE_SERVLET

	// item Servlets
	public static final String ITEM_COMMIT_SERVLET = "/itemcommit"; //WebPath.ITEM_COMMIT_SERVLET
	public static final String ITEM_CANCEL_SERVLET = "/itemcancel"; //WebPath.ITEM_CANCEL_SERVLET
	public static final String ITEM_CREATE_SERVLET = "/itemcreate"; //WebPath.ITEM_CREATE_SERVLET
	public static final String ITEM_EDIT_SERVLET = "/itemedit"; //WebPath.ITEM_EDIT_SERVLET
	public static final String ITEM_DELETE_SERVLET = "/itemdelete"; //WebPath.ITEM_DELETE_SERVLET
}
