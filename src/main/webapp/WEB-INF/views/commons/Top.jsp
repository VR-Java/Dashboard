<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="resourses/css/materialize.min.css">
<link type="text/css" rel="stylesheet" href="resourses/css/myStyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>${pageTitle}</title>
</head>
<body>
	<nav class="black lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="${base}/useritems" class="brand-logo">DASHBOARD</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="${base}/usercreate">${userDTO.name}</a></li>
				<li><a href="${base}/logout">Logout</a></li>
			</ul>
		</div>
	</nav>