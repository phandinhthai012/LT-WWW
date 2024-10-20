<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function validateForm() {

    var noiDungTT = document.getElementById("noiDungTT").value;
    var lienKet = document.getElementById("lk").value;

    // Kiểm tra định dạng URL
    var regexURL = /^http:\/\/.*/;
    if (!regexURL.test(lienKet)) {
        alert("Liên kết phải bắt đầu bằng 'http://'");
        return false;
    }

    // Kiểm tra độ dài nội dung
    if (noiDungTT.length > 255) {
        alert("Nội dung không được quá 255 ký tự.");
        return false;
    }

    // Nếu không có lỗi nào, form hợp lệ
    return true;
}
</script>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="content">
		<form action="../../TinTucFormServlet" method="post" onsubmit="return validateForm()">
			<table>
				<tr>
					<td><label for="tieuDe">Mã tin tức</label></td>
					<td><input type="text" id="maTT" name="maTT" required ></td>
				</tr>
				<tr>
					<td><label for="tieuDe">Tiêu đề</label></td>
					<td><input type="text" id="tieuDe" name="tieuDe" required ></td>
				</tr>
				<tr>
					<td><label for="noiDungTT">Nội dung</label></td>
					<td><textarea rows="4" cols="50" id="noiDungTT"
							name="noiDungTT" required ></textarea></td>
				</tr>
				<tr>
					<td><label for="lk" >Liên kết</label></td>
					<td><textarea rows="4" cols="50" id="lk" name="lienKet" required  ></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><h3>Danh mục</h3></td>
				</tr>
				<tr>
					<td><label for="maDM">Mã danh mục</label></td>
					<td><input type="text" id="maDM" name="maDM" required ></td>
				</tr>
				<tr>
					<td><label for="tenDM">Tên danh mục</label></td>
					<td><input type="text" id="tenDM" name="tenDM" required ></td>
				</tr>
				<tr>
					<td><label for="nguoiQuanLy">Người quản lí</label></td>
					<td><input type="text" id="nguoiQuanLy" name="nguoiQuanLy" required ></td>
				</tr>
				<tr>
					<td><label for="ghiChu">Ghi chú</label></td>
					<td><input type="text" id="ghiChu" name="ghiChu" required > <br></td>
				</tr>

			</table>

			<input type="submit" value="Thêm Tin Tức" class="btn">
		</form>
	</div>
	<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<style>
.content {
	display: flex;
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

td {
	padding: 10px;
}

td input {
	width: 100%;
}

form {
	margin: 32px;
}

label {
	font-weight: bold;
	width: 100%;
}

.btn {
	margin: 10px;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</html>