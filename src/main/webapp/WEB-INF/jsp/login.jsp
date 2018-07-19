<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<t:layout title="Login">
	<jsp:body>
		<form action="" method="post">
			<sec:csrfInput/>
			<c:if test="${param.error != null }">
				<span>用户名或密码错误</span>
			</c:if>
			<div>
				<label for="username">用户名:</label>
				<input type="text" name="username" id="username"/>
			</div>
			<div>
				<label for="password">密 码:</label>
				<input type="password" name="password" id="username"/>
			</div>
			<div>
				<input type="submit" value="确定"/>
			</div>
		</form>
		
	</jsp:body>


</t:layout>