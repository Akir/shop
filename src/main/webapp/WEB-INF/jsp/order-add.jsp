<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<t:layout title="Order Add">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<h1>Order Add</h1>
		<table class="table">
			<tr>
				<th>商品名称</th>
				<th>价格</th>
				<th>数量</th>
			</tr>
			<c:forEach items="${shoppingCart.shoppingCartItems }" var="shoppingCartItem">
				<tr>
					<td>${shoppingCartItem.cellPhone.model }</td>
					<td>${shoppingCartItem.cellPhone.price/100 }</td>
					<td>${shoppingCartItem.quantity }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">总计:${shoppingCart.totalAmount/100 }</td>
			</tr>
		</table>
		<c:if test="${shippingAddress[0] != null }">
			<form:form action="" method="post" commandName="order">
				<sec:csrfInput/>
				<input hidden="hidden" name="shoppingCart" value="${shoppingCart }">
				<form:select path="shippingAddress.id" items="${shippingAddress }" 
									itemLabel="address" 
									itemValue="id">
				</form:select>
				<div><button>确认购买</button></div>
			</form:form>
		</c:if>
		<c:if test="${shippingAddress[0] == null}">
			<span>你好像还没有收货人，<a href="${contextPath}/uc/shippingAddress/add">新建收货人</a></span>
		</c:if>
	</jsp:body>
</t:layout>