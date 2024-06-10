<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
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
                        Mã người dùng: ${nguoidunglogin.maNguoiDung}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Tên người dùng: ${nguoidunglogin.tenNguoiDung}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Ngày sinh: <fmt:formatDate value="${nguoidunglogin.ngaySinh}" pattern="dd/MM/yyyy" />
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Chức vụ: ${nguoidunglogin.chucVu}
                    </span>
                </li>
                <li class="input-group mb-3 w-100 d-flex justify-content-center">
                    <span class="form-control form-control-lg bg-light fs-6 w-75">
                        Nhóm người dùng: ${nguoidunglogin.nhomNguoiDung.tenNhomNguoiDung}
                    </span>
                </li>
                <a href="doimatkhau.htm" class="btn btn-outline-success" style="background-color: #634832; color: white;">Đổi mật khẩu</a>
                
            </ul>

	    
	  </div>
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-beta1/js/bootstrap.min.js"></script>
</body>
</html>