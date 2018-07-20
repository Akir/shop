<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Home">
	<jsp:body>
		<h2>手机搜索</h2>
		<form:form action="${contextPath}/CellPhone/search" method="post" commandName="cellPhoneForm">
			<div>
				<form:label path="brandName">品牌 </form:label>
				<form:input path="brandName"/>
			</div>
			<div>
				<form:label path="model">型号 </form:label>
				<form:input path="model"/>
			</div>
			<div>
				<form:label path="os">系统 </form:label>
				<form:input path="os"/>
			</div>
			<div>
				<form:label path="cpu">CPU</form:label>
				<form:input path="cpu"/>
			</div>
			<div>
				<form:label path="ram">RAM</form:label>
				<form:input path="ram"/>
			</div>
			<div>
				<form:label path="storage">ROM</form:label>
				<form:input path="storage"/>
			</div>
			<div>
				<input type="submit" value="确定">
			</div>
		</form:form>
	</jsp:body>
</t:layout>







