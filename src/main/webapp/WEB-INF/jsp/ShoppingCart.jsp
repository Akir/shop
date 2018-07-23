<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Home">
	<jsp:body>
		<h1>Shopping Cart</h1>
		<table>
			<tr>
				<th>商品名称</th>
				<th>价格</th>
				<th>数量</th>
			</tr>
			<c:forEach items="${ShoppingCart }" var="CellPhone">
				<tr>
					<td>${CellPhone.cellPhone.model }</td>
					<td>${CellPhone.cellPhone.price/100 }</td>
					<td>${CellPhone.quantity }</td>
				</tr>
			</c:forEach>
		</table>
	</jsp:body>
</t:layout>