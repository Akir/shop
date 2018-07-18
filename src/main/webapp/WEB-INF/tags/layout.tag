<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="title" required="true"%>
<%@ attribute name="css" fragment="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link href="${contextPath }/assets/css/header.css" rel="stylesheet">
<jsp:invoke fragment="css" />
</head>
<body>
	<div class="header">
		<div class="menu">
			<ul>
				<li><a href="${contextPath }/">[首页]</a></li>
			</ul>
		</div>
	</div>

	<div class="body">
		<jsp:doBody></jsp:doBody>
	</div>

	<div class="footer">copyright 2018</div>
</body>
</html>
