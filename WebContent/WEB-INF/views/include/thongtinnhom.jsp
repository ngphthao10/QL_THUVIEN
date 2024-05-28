<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý tựa sách</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container">
					<h3 class="mt-4">Thông tin nhóm</h3>
					<div class="row mt-4">
						<div class="col-sm-4 mb-3 mb-sm-0">
							<div class="card border-dark h-100">
								<h5 class="card-header">Thành viên 1</h5>
								<div class="card-body">
									<p class="card-text">
									<div>Họ tên: Nguyễn Thị Phương Thảo</div>
									<div>MSSV: N21DCCN078</div>
									<div>Mô tả công việc:</div>
									<li>Sách (gồm: Tựa sách, Sách, Cuốn sách, Thể loại, Phiếu
										nhập sách)</li>
									<li>Đổi quy định</li>
									<li>Giao diện riêng cho Độc giả (Thông tin độc giả, Tra
										cứu sách, Sách đã mượn)</li>
									<li>Giao diện trang chủ (dashboard)</li>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="card border-dark h-100">
								<h5 class="card-header">Thành viên 2</h5>
								<div class="card-body">
									<p class="card-text">
									<div>Họ tên: Nguyễn Thị Minh Thư</div>
									<div>MSSV: N21DCCN082</div>
									<div>Mô tả công việc:</div>
									<li>Phiếu mượn trả (gồm: thêm, sửa phiếu)</li>
									<li>Phiếu thu (gồm: thêm, sửa phiếu)</li>
									<li>Chức năng login, đổi mật khẩu</li>
									<li>Người dùng (gồm: Người dùng, Nhóm người dùng)</li>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="card border-dark h-100">
								<h5 class="card-header">Thành viên 3</h5>
								<div class="card-body">
									<p class="card-text">
									<div>Họ tên: Đặng Ngọc Yến</div>
									<div>MSSV: N21DCCN097</div>
									<div>Mô tả công việc:</div>
									<li>Độc giả (gồm: Thông tin độc giả, Loại độc giả)</li>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
