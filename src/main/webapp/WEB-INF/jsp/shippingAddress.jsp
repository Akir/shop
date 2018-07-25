<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Shipping Address">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<h1>Shipping Address</h1>
		<table class="table">
			<c:if test="${shippingAddresses[0] == null }">
				<tr>
					<td>
						<a href="${contextPath}/uc/shippingAddress/add">添加收货人</a>
					</td>
				</tr>
			</c:if>
			<c:if test="${shippingAddresses[0] != null }">
				<tr>
					<th>收货人姓名</th>
					<th>手机号码</th>
					<th>详细地址</th>
					<th>选项</th>
				</tr>
				<c:forEach items="${shippingAddresses }" var="shippingAddress">
					<tr>
						<td>${shippingAddress.name }</td>
						<td>${shippingAddress.phoneNumber }</td>
						<td>${shippingAddress.address }</td>
						<td>
							<a href="${contextPath}/uc/shippingAddress/edit/${shippingAddress.id}">编辑</a>
							<a href="${contextPath}/uc/shippingAddress/delete/${shippingAddress.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">
						<a href="${contextPath}/uc/shippingAddress/add">添加收货人</a>
					</td>
				</tr>
			</c:if>
		</table>
	</jsp:body>
</t:layout>