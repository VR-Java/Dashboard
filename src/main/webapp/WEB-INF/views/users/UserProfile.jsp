<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="User profile" />
<c:import url="/WEB-INF/views/commons/Top.jsp" charEncoding="utf-8" />

<main>
<div class="container maxwidth800">

	<div class="row center">
		<h5>WELLCOME ${userDTO.name}!</h5>
	</div>

	<div class="row center">
		<div class="col s12">

			<form action="${base}/usercreate" method="post">
				<input type="text" name="name" placeholder="Name:"
					value="${userDTO.name}"> <input type="text" name="login"
					placeholder="Login:" value="${userDTO.login}"> <input
					type="password" name="password" placeholder="Password:"> <input
					type="password" name="confirmpassword"
					placeholder="Confirm password:"> <input type="text"
					name="email" placeholder="Email:" value="${userDTO.email}">
				<button
					class="btn col s12 waves-effect waves-light blue-grey darken-3"
					type="submit" name="register" value="Submit" method="post">
					<i class="material-icons center">Submit</i>
				</button>
			</form>
			<br> <br> <br>
			<form action="${base}/usercancel" method="post">
				<button
					class="btn col s12 waves-effect waves-light blue-grey darken-3"
					type="submit" name="cancel" value="Cancel" method="post">
					<i class="material-icons center">Cancel</i>
				</button>
			</form>
		</div>
	</div>
</div>
</main>
<c:import url="/WEB-INF/views/commons/Footer.jsp" charEncoding="utf-8" />