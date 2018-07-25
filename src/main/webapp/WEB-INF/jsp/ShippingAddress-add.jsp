<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Address Add">
	<jsp:body>
		<h1>Address Add</h1>
		<form:form action="" method="post" commandName="shippingAddress">
			<div>
				<form:label path="name">收货人姓名:</form:label>
				<form:input path="name"/>
				<form:errors path="name" cssClass="form-errors"/>
			</div>
			<div>
				<form:label path="phoneNumber">电话号码:</form:label>
				<form:input path="phoneNumber"/>
				<form:errors path="phoneNumber" cssClass="form-errors"/>
			</div>
			<div>
				<form:label path="address">详细地址:</form:label>
				<form:input path="address"/>
				<form:errors path="address" cssClass="form-errors"/>
			</div>
			<div>
				<input type="submit" value="确定">
			</div>
		</form:form>
	</jsp:body>
</t:layout>







