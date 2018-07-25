<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="title" required="true"%>
<%@ attribute name="css" fragment="true" %>
<sec:authentication property="principal" var="username"/>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link href="${contextPath }/assets/css/header.css" rel="stylesheet">
<link href="${contextPath }/assets/css/footer.css" rel="stylesheet">
<jsp:invoke fragment="css" />
</head>
<body>
	<div class="header">
		<div class="menu">
			<ul>
				<li><a href="${contextPath }/">[首页]</a></li>
			
				<c:if test="${username == 'anonymousUser' }">
						<a href="${contextPath }/register">[注册] </a>
						<a href="${contextPath }/login">[登录]</a>
				</c:if>
				<c:if test="${username != 'anonymousUser' }">
					<li>
						<span>${username.username } </span>
						<ul>
							<li><a href="${contextPath }/uc/ShoppingCart">购物车管理</a></li>
							<li><a href="${contextPath }/uc/shippingAddress">收货人管理</a></li>
							<li><a href="${contextPath }/uc/order">订单管理</a></li>
							<li>
								<form action="${contextPath }/logout" method="post" style="display: inline-block;">
									<sec:csrfInput/>
									<input type="submit" value="退出" style="background-color: transparent; border: none;">
								</form>
							</li>
						</ul>
					</li>
				</c:if>
			</ul>
		</div>
	</div>

	<div class="body">
		<jsp:doBody></jsp:doBody>
	</div>

	<div class="footer">copyright 2018</div>
</body>
</html>
