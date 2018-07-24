<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Shopping Cart">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<h1>Shopping Cart</h1>
		<table class="table">
			<c:if test="${shoppingCart.shoppingCartItems[0] == null }">
				<tr><td>空空如也<td></tr>
			</c:if><c:if test="${shoppingCart.shoppingCartItems[0] != null }">
				<tr>
					<th>商品名称</th>
					<th>价格</th>
					<th>数量</th>
					<th>选项</th>
				</tr>
				<c:forEach items="${shoppingCart.shoppingCartItems }" var="shoppingCartItem">
					<tr>
						<td>${shoppingCartItem.cellPhone.model }</td>
						<td>${shoppingCartItem.cellPhone.price/100 }</td>
						<td>${shoppingCartItem.quantity }</td>
						<td>
							<form action="" method="post">
								<sec:csrfInput/>
								<input hidden="hidden" name="quantity" value="${shoppingCartItem.quantity }">
								<button name="operate" value="${shoppingCartItem.cellPhone.id }:1">减少</button>
								<button name="operate" value="${shoppingCartItem.cellPhone.id }:2">增加</button>
								<button name="operate" value="${shoppingCartItem.cellPhone.id }:3">删除</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">总计:${shoppingCart.totalAmount/100 }</td>
				</tr>
			</c:if>
			
		</table>
	</jsp:body>
</t:layout>