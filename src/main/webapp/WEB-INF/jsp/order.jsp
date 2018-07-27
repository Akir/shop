<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<t:layout title="Order">
	<jsp:attribute name="css">
		<link href="${contextPath }/assets/css/table.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<h1>Order</h1>
		<table class="table">
			<c:forEach items="${orders }" var="order">
				<tr class="firstFloorTr">
					<th>订单号</th>
					<th>收货人</th>
					<th>电话号码</th>
					<th>地址</th>
					<th>创建时间</th>
				</tr>
				<tr>
					<td>${order.id }</td>
					<td>${order.shippingAddress.name }</td>
					<td>${order.shippingAddress.phoneNumber }</td>
					<td>
						${order.shippingAddress.address} 
						<a href="${contextPath}/uc/order/address/${order.id}">[更换]</a>
					</td>
					<td><fmt:formatDate value="${order.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr class="secondFloorTr">
					<th></th>
					<th colspan="2">商品名称</th>
					<th>价格</th>
					<th>数量</th>
				</tr>
				<c:forEach items="${order.orderItems }" var="orderItem">
					<tr>
						<td></td>
						<td colspan="2">${orderItem.cellPhone.brand.name} ${orderItem.cellPhone.model}</td>
						<td>${orderItem.cellPhone.price/100}</td>
						<td>${orderItem.quantity}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td colspan="4">总金额: ${order.totalAmount/100}</td>
				</tr>
			</c:forEach>
		</table>
	</jsp:body>

</t:layout>