<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<div class="offcanvas offcanvas-end" tabindex="-1" id="infoBar" aria-labelledby="offcanvasRightLabel">
	  <div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasRightLabel">Thông tin tài khoản</h5>
	    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	  </div>
	  <div class="offcanvas-body">
	  
	  		<ul class="list-unstyled w-100 d-flex flex-column align-items-center">
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Mã người dùng: ${nguoidung.maNguoiDung}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Tên người dùng: ${nguoidung.tenNguoiDung}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Ngày sinh: <fmt:formatDate value="${nguoidung.ngaySinh}" pattern="dd/MM/yyyy" />
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Chức vụ: ${nguoidung.chucVu}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Nhóm người dùng: ${nguoidung.nhomNguoiDung.tenNhomNguoiDung}
                    </span>
                </li>
                
                <li class="w-100 d-flex justify-content-center">
                    <a href="home/doimatkhau.htm" class="btn btn-outline-success" style="background-color: #634832; color: white;">Đổi mật khẩu</a>
                </li>
            </ul>

	    
	  </div>
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-beta1/js/bootstrap.min.js"></script>
</body>
</html>