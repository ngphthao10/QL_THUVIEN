<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
     <div class="modal fade" id="insertDocGiaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog">
         <div class="modal-content">
           <div class="modal-header" style="background-color: #9b704c; color: white">
      <h1 class="modal-title fs-5" id="exampleModalLabel">THÊM THẺ ĐỘC GIẢ</h1>
      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    </div>
           
    <div class="modal-body " style="text-align: left;" >
      <form:form class="row g-3 mt-2" action = "docgia/listDocGia.htm?insert" modelAttribute="docgiaDTO" method="post">
      
        <div class="col-12 modal-item" >
          <label for="docgia.tenDocGia" class="form-label">Họ tên *</label>
          <input name="docgia.tenDocGia" id="docgia.tenDocGia" type="text" class="form-control" placeholder="Nhập họ và tên">
          <div class="invalid-feedback">
          	<form:errors path="docgia.tenDocGia"></form:errors>
         </div> 
        </div>
        
        <div class="col-md-6 modal-item">
          <label for="docgia.ngaySinh" class="form-label">Ngày sinh *</label>
          <input name="docgia.ngaySinh" id="docgia.ngaySinh" type="text" class="form-control" placeholder="dd/mm/yyyy">
          <div class="invalid-feedback">
          	<form:errors path="docgia.ngaySinh"></form:errors>
         </div>
        </div>
             
		<div class="col-md-6 modal-item">
		    <label for="docgia.loaiDocGia.id" class="form-label">Loại độc giả *</label>
	         <select id="loaiDocGia" name="docgia.loaiDocGia.id" class="form-select">
		        <c:forEach var="loaiDocGia" items="${listLDG}">
		            <option value="${loaiDocGia.id}">${loaiDocGia.tenLoaiDocGia}</option>
		        </c:forEach>
		    </select>
		</div> 
  
        <div class="col-12 modal-item">
          <label for="docgia.diaChi" class="form-label">Địa chỉ</label>
          <input name="docgia.diaChi" id="docgia.diaChi" type="text" class="form-control" placeholder="Nhập địa chỉ">
          <div class="invalid-feedback">
          	<form:errors path="docgia.diaChi"></form:errors>
         </div>
        </div>

        <div class="col-12 modal-item">
          <label for="docgia.email" class="form-label">Email</label>
          <input name="docgia.email" id="docgia.email" type="email" class="form-control" placeholder="xyz@gmail.com">
          <div class="invalid-feedback">
          	<form:errors path="docgia.email"></form:errors>
         </div>
        </div>

        <%-- <div class="col-md-6 modal-item">
          <label for="docgia.nguoiDung.username" class="form-label">Tên đăng nhập *</label>
          <input name="docgia.nguoiDung.username" id="docgia.nguoiDung.username" type="text" class="form-control">
          <div class="invalid-feedback">
          	<form:errors path="docgia.nguoiDung.username"></form:errors>
         </div>
        </div>

        <div class="col-md-6 modal-item">
          <label for="docgia.nguoiDung.password" class="form-label">Mật khẩu *</label>
          <input name="docgia.nguoiDung.password" id="docgia.nguoiDung.password" type="password" class="form-control">
          <div class="invalid-feedback">
          	<form:errors path="docgia.nguoiDung.password"></form:errors>
         </div>
        </div>

        <div class="col-md-6 modal-item">
          <label for="docgia.nguoiDung.chucVu" class="form-label">Chức vụ</label>
          <input name="docgia.nguoiDung.chucvu" id="docgia.nguoiDung.chucVu" type="text" class="form-control">
        </div> --%>
        
        <div class="col-md-6 modal-item">
          <label for="docgia.ngayLapThe" class="form-label">Ngày lập thẻ</label>
          <input name="docgia.ngayLapThe" id="docgia.ngayLapThe" value="${ngayLapThe}" type="text" class="form-control" readonly>
        </div>
        
        <div class="col-md-6 modal-item">
          <label for="docgia.ngayHetHan" class="form-label">Ngày hết hạn</label>
          <input name="docgia.ngayHetHan" id="docgia.ngayHetHan" value="${ngayHetHan}" class="form-control" type="text" readonly>
        </div>

		<div class="modal-footer">
           <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
           <button type="submit" class="btn btn-success">Thêm</button>
        </div>

        </form:form>
       </div>
       
     </div>
   </div>
 </div>
     
</body>
</html>