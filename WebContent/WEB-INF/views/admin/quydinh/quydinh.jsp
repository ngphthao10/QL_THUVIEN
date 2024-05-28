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
<title>Thay đổi quy định</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
<style>
.button-container {
	text-align: right;
}

.button-container .modal-body {
	text-align: left;
}

.modal-content {
	background-color: #ece0d1;
}

.modal-header {
	background-color: #634832;
	color: #fff;
}

.center-table {
	vertical-align: middle;
}

.centered-column {
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container mt-3">
					<c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == -1}">
								<div class="alert alert-warning mt-2 me-2" role="alert">
									Các trường còn trống hoặc chưa chính xác!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2 me-2" role="alert">
									Lưu quy định thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Lưu quy định thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
				</div>
				<div class="container">
					<form:form class="row g-3 needs-validation mt-3" method="POST"
							action="quydinh/index.htm" modelAttribute="thamso">
						<div><h3>Quy định về độc giả</h3></div>
						<hr>
						<form:hidden path="id"/>
						<div class="col-md-4">
							<label class="form-label">Thời hạn thẻ độc giả (đơn vị: tháng)</label>
							<form:input path="ThoiHanThe"  type="text" class="form-control" placeholder="VD: 4 (tháng)" required="true"/>
							<div style="color:red;"><form:errors path="ThoiHanThe"/></div>
						</div>
						<div class="col-md-4">
							<label class="form-label">Tuổi tối thiểu của độc giả</label>
							<form:input path="TuoiToiThieu" type="text" class="form-control" placeholder="VD: 5 tuổi" required="true"/>
							<div style="color:red;"><form:errors path="TuoiToiThieu"/></div>
						</div>
						<div class="col-md-4">
							<label class="form-label">Tuổi tối đa của độc giả</label>
							<form:input path="TuoiToiDa" type="text" class="form-control" placeholder="VD: 80 tuổi" required="true"/>
							<div style="color:red;"><form:errors path="TuoiToiDa"/></div>
						</div>
						<div><h3>Quy định về sách và mượn trả</h3></div>
						<hr>
						<div class="col-md-3">
							<label class="form-label">Số ngày mượn tối đa</label>
							<form:input path="SoNgayMuonToiDa" type="text" class="form-control" placeholder="VD: 7 ngày" required="true"/>
							<div style="color:red;"><form:errors path="SoNgayMuonToiDa"/></div>
						</div>
						<div class="col-md-3">
							<label class="form-label">Đơn giá phạt trễ (đơn vị: VNĐ)</label>
							<form:input path="DonGiaPhat" type="text" class="form-control" placeholder="VD: 10000 (đồng)" required="true"/>
							<div style="color:red;"><form:errors path="DonGiaPhat"/></div>
						</div>
						<div class="col-md-3">
							<label class="form-label">Số sách mượn tối đa</label>
							<form:input path="SoSachMuonToiDa" type="text" class="form-control" placeholder="VD: 5 sách" required="true"/>
							<div style="color:red;"><form:errors path="SoSachMuonToiDa"/></div>
						</div>
						<div class="col-md-3">
							<label class="form-label">Khoảng cách năm xuất bản tối đa</label>
							<form:input path="KhoangCachXuatBan" type="text" class="form-control" placeholder="VD: 8 năm" required="true"/>
							<div style="color:red;"><form:errors path="KhoangCachXuatBan"/></div>
						</div>
				<%-- 		<div class="col-6 mt-4">
							<div class="row">
								<label class="col-sm-8"> Số tiền thu không được quá số tiền nợ: </label>
								<div class="form-check col-sm-2">
							    	<form:radiobutton class="form-check-input" value="1" id="validationFormCheck2" path="AD_QDKTTienThu" required="true"/>
							    	<label class="form-check-label" for="validationFormCheck2">Có</label>
							  	</div>
							  	<div class="form-check mb-3 col-sm-2">
							    	<form:radiobutton class="form-check-input" value="0" id="validationFormCheck3" path="AD_QDKTTienThu" required="true"/>
							    	<label class="form-check-label" for="validationFormCheck3">Không</label>
							  	</div>
							</div>
						</div> --%>
						<div class="col-12" style="text-align:right;">
							<button name="editbtn" class="btn btn-primary" type="submit" >
							  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy mb-1" viewBox="0 0 16 16">
							    <path d="M11 2H9v3h2z"/>
							    <path d="M1.5 0h11.586a1.5 1.5 0 0 1 1.06.44l1.415 1.414A1.5 1.5 0 0 1 16 2.914V14.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 14.5v-13A1.5 1.5 0 0 1 1.5 0M1 1.5v13a.5.5 0 0 0 .5.5H2v-4.5A1.5 1.5 0 0 1 3.5 9h9a1.5 1.5 0 0 1 1.5 1.5V15h.5a.5.5 0 0 0 .5-.5V2.914a.5.5 0 0 0-.146-.353l-1.415-1.415A.5.5 0 0 0 13.086 1H13v4.5A1.5 1.5 0 0 1 11.5 7h-7A1.5 1.5 0 0 1 3 5.5V1H1.5a.5.5 0 0 0-.5.5m3 4a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5V1H4zM3 15h10v-4.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5z"/>
							  </svg>
							  Lưu thông tin</button>
						</div>
					</form:form>    
				</div>
			</div>
		</div>
	</div>
	<script>
      (() => {
      'use strict'

        const forms = document.querySelectorAll('.needs-validation')
          Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
              if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
              }

              form.classList.add('was-validated')
            }, false)
          })
        })()
    </script>
</body>
</html>
