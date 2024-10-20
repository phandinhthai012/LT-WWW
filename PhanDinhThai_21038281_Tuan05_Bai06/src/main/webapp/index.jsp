<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  pageEncoding="ISO-8859-1"%>--%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Giảng viên - Đề tài</title>
</head>
<body>
	<jsp:forward page="${pageContex.request.contextPath}/DeTaiController"></jsp:forward>
</body>
</html>