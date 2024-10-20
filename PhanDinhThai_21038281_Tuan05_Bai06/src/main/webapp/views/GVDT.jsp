<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%--  pageEncoding="ISO-8859-1"%>--%> 
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8" >
<title>Giảng viên - Đề tài</title>
</head>
<body>

	<table>
		<tr>
			<th>Faculty ID</th>
			<th>Full Name</th>
			<th>Research Area</th>
			<th>Telephone number</th>
		</tr>
		<c:forEach var="GV" items="${DSGV}">
			<c:set var="maGV" value="${GV.maGV}"></c:set>
			<tr>
				<td>${maGV}</td>
				<td>
					<p>${GV.tenGV}</p>
					<p class="dsdt">Danh Sách Đề tài</p>
					<ul>
						<c:forEach var="DT" items="${DSDT}">
							<c:if test="${fn:toLowerCase(DT.maGV) == fn:toLowerCase(maGV)}">  <!-- c:if test="${DT.maGV == maGV}"> -->
								<li>${DT.tenDT}</li>
							</c:if>
						</c:forEach>	
					</ul>
				</td>
				<td>
					<p>${GV.linhVucNghienCuu}</p>
				</td>
				<td>
					<p>${GV.soDienThoai}</p>
				</td>
			</tr>

		</c:forEach>

	</table>
</body>

<style>
table {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
}

th, td, tr {
	text-align: left;
	padding: 8px;
	border: 1px solid #ddd;
}

p {
	margin: 0 12px;
	font-size: 1em;
	
}

.dsdt {
	font-weight: bold;
	text-decoration: underline;
}
</style>
</html>