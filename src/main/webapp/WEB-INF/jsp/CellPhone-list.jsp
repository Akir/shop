<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<t:layout title="CellPhone List">
	<jsp:body>
		<h1>CellPhone List</h1>
		<ul>
			<c:forEach items="${cellPhoneForm }" var="CellPhone">
				<li>#${CellPhone.id } 
					<a href="${contextPath }/CellPhone/${CellPhone.id}">
						${CellPhone.model }
					</a>
					<a href="${contextPath }/CellPhone/${CellPhone.id}/delete">[删除]</a>
				</li>
			</c:forEach>
		</ul>
	</jsp:body>
</t:layout>