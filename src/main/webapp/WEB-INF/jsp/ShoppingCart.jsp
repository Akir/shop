<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="Shopping Cart">
	<jsp:attribute name="css">
		<sec:csrfMetaTags/>
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:attribute name="js">
		<script type="text/javascript" src="${contextPath }/assets/vendor/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="${contextPath }/assets/js/shoppingCart.js"></script>
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
					<tr class="${shoppingCartItem.cellPhone.id }">
						<td>${shoppingCartItem.cellPhone.model }</td>
						<td>${shoppingCartItem.cellPhone.price/100 }</td>
						<td id="${shoppingCartItem.cellPhone.id }">${shoppingCartItem.quantity }</td>
						<td>
							<button name="operate" value="${shoppingCartItem.cellPhone.id }:1" data-quantity="${shoppingCartItem.quantity }">减少</button>
							<button name="operate" value="${shoppingCartItem.cellPhone.id }:2" data-quantity="${shoppingCartItem.quantity }">增加</button>
							<button name="operate" value="${shoppingCartItem.cellPhone.id }:3" data-quantity="${shoppingCartItem.quantity }">删除</button>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" id="totalAmount">总计:<fmt:formatNumber value="${shoppingCart.totalAmount/100}" pattern="0.00"/></td>
					<td>
						<form action="${contextPath}/uc/order/add" method="get">
							<button>结算</button>
						</form>
					</td>
				</tr>
			</c:if>
		</table>
	</jsp:body>
</t:layout>