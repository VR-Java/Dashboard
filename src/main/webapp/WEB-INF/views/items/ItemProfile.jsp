<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="Item profile" />
<c:import url="/WEB-INF/views/commons/Top.jsp" charEncoding="utf-8" />

<main>
<div class="container maxwidth600">

	<div class="row center">
		<h3>ADD NEW ITEM</h3>
	</div>

	<div class="row center">
		<div class="col s12">
			<form action="${base}/itemcreate" method="post">
				<input type="text" name="title" placeholder="Title:"
					value="${itemDTO.title}"> <input type="text"
					name="description" placeholder="Description:"
					value="${itemDTO.description}"> <input type="text"
					name="status" placeholder="Status:" value="${itemDTO.status}">


				<br> <br>
				<button
					class="btn col s12 waves-effect waves-light blue-grey darken-3"
					type="submit" name="submit" value="Submit" method="post">
					<i class="material-icons center">Submit</i>
				</button>
			</form>
			<br> <br> <br>
			<form action="${base}/itemcancel" method="post">
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