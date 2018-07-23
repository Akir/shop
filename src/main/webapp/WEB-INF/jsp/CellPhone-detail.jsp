<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="CellPhone-Detail">
	<jsp:body>
		<h1>CellPhone-Detail</h1>
		<form action="${contextPath}/uc/CellPhone/${CellPhone.id }" method="post">
			<sec:csrfInput/>
			<input type="submit" value="添加到购物车">
		</form>
		<h3>${CellPhone.model }</h3>
		<ul>
			<li>Price: ${CellPhone.price/100 }</li>
		</ul>
	</jsp:body>


</t:layout>