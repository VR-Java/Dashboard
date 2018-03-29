<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="User Items" />
<c:import url="/WEB-INF/views/commons/Top.jsp" charEncoding="utf-8" />

<main>
<div class="container">
	<div class="row center">
		<h5>${userDTO.name}'s items:</h5>
	</div>

	<div class="row center">
		<i class="material-icons center"> <a href="${base}/itemcreate"
			id="download-button"
			class="btn-large col s12 waves-effect waves-light blue-grey darken-3">Add
				new Item</a>
		</i>
	</div>

	<div class="row center">
		<div class="col s12">
			<table width=100%>
				<tr>
					<th width=5%>Position</th>
					<th width=20%>Title</th>
					<th width=40%>Description</th>
					<th width=15%>Status</th>
					<th width=10%>Edit</th>
					<th width=10%>Delete</th>
				</tr>
				<c:if test="${!empty userItemsDTO.items}">
					<c:forEach items="${userItemsDTO.items}" var="item"
						varStatus="count">
						<tr>
							<td>${count.count}</td>
							<td>${item.title}</td>
							<td>${item.description}</td>
							<td>${item.status}</td>
							<td><a href="${base}/itemedit?idItem=${item.idItem}">edit</a></td>
							<td><a href="${base}/itemdelete?idItem=${item.idItem}">delete</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</div>
</main>

<c:import url="/WEB-INF/views/commons/Footer.jsp" charEncoding="utf-8" />