<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<t:layout title="Register">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/form.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<h2>注册</h2>
		<form:form action="" method="post" commandName="username">
			<div>
				<form:label path="username">用户名:</form:label>
				<form:input path="username"/>
				<form:errors path="username" cssClass="form-errors"/>
			</div>
			
			<div>
				<form:label path="password">密 码:</form:label>
				<form:password path="password"/>
				<form:errors path="password" cssClass="form-errors"/>
			</div>
			<div>
				<input type="submit" value="确定">
			</div>
		</form:form>
	</jsp:body>
</t:layout>