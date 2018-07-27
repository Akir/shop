<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<t:layout title="order-address">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<form action="" method="post">
			<sec:csrfInput/>
			<table class="table">
				<tr>
					<th>选择</th>
					<th>收货人</th>
					<th>电话</th>
					<th>地址</th>
				</tr>
				
				<c:forEach items="${shippingAddresses}" var="shippingAddress">
					<tr>
						<td><input type="radio" name="addressId" value="${shippingAddress.id }"></td>
						<td>${shippingAddress.name }</td>
						<td>${shippingAddress.phoneNumber }</td>
						<td>${shippingAddress.address }</td>
					</tr>
				</c:forEach>
			</table>
			<input type="radio" name="addressId" hidden="hidden" checked="checked" value="">
			<button>确定</button>
			<a href="${contextPath}/uc/order"><button type="button">取消</button></a>
		</form>
	</jsp:body>

</t:layout>