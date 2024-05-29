<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
    
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>

	<div class="button-container">
		<div class="modal fade" id="editThongTinDGModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
             <div class="modal-dialog">
               <div class="modal-content">
                 <div class="modal-header" style="background-color: #9b704c; color: white">
                   <h1 class="modal-title fs-5" id="exampleModalLabel">SỬA THẺ ĐỘC GIẢ</h1>
                   <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                 </div>
                 
                 <div class="modal-body" style="text-align: left;" >
                   <form:form class="row g-3 mt-2" action = "docgia/thongtinDG.htm?edit&id=${docgiaDTO.docgia.id}" modelAttribute="docgiaDTO" method="post">
                   
                     <div class="col-md-6 modal-item">
                       <label for="docgia.maDocGia" class="form-label">Mã độc giả</label>
                       <input name="docgia.maDocGia" id="docgia.maDocGia" value="${docgiaDTO.docgia.maDocGia}" type="text" class="form-control" readonly>
                     </div>
                     
                     <div class="col-12 modal-item">
                       <label for="docgia.tenDocGia" class="form-label">Họ tên*</label>
                       <input name="docgia.tenDocGia" id="docgia.tenDocGia" value="${docgiaDTO.docgia.tenDocGia}" type="text" class="form-control" placeholder="Nhập họ và tên">
                       <div class="invalid-feedback">
                     		<form:errors path="docgia.tenDocGia"></form:errors>
                    	</div>
                     </div>
                     
                     <div class="col-md-6 modal-item">
                       <label for="docgia.ngaySinh" class="form-label">Ngày sinh*</label>
                       <input name="docgia.ngaySinh" id="docgia.ngaySinh" value="${docgiaDTO.docgia.formattedNgaySinh}" type="text" class="form-control" placeholder="dd/mm/yyyy" >
                       <div class="invalid-feedback">
                     		<form:errors path="docgia.ngaySinh"></form:errors>
                    	</div>
                     </div>
                     
                     <div class="col-md-6 modal-item">
					    <label for="docgia.loaiDocGia.tenLoaiDocGia" class="form-label">Loại độc giả*</label>
					    <form:select id="docgia.loaiDocGia.tenLoaiDocGia" path="docgia.loaiDocGia.id" class="form-select">
					        <form:options items="${listLDG}" itemValue="id" itemLabel="tenLoaiDocGia" />
					    </form:select>
					</div>
                     
                     <div class="col-12 modal-item">
                       <label for="docgia.diaChi" class="form-label">Địa chỉ</label>
                       <input name="docgia.diaChi" id="docgia.diaChi" value="${docgiaDTO.docgia.diaChi}" type="text" class="form-control" placeholder="Nhập địa chỉ">
                     	<div class="invalid-feedback">
                     		<form:errors path="docgia.diaChi"></form:errors>
                    	</div>
                     </div>
                     
                     <div class="col-12 modal-item">
                       <label for="docgia.email" class="form-label">Email</label>
                       <input name="docgia.email" id="docgia.email" value="${docgiaDTO.docgia.email}" type="email" class="form-control" placeholder="xyz@gmail.com">
                     	<div class="invalid-feedback">
                     		<form:errors path="docgia.email"></form:errors>
                    	</div>
                     </div>
                     
                     <div class="col-md-6 modal-item">
                       <label for="docgia.ngayLapThe" class="form-label">Ngày lập thẻ</label>
                       <input name="docgia.ngayLapThe" id="ngayLapThe" value="${docgiaDTO.docgia.formattedNgayLapThe}" type="text" class="form-control" placeholder="Disabled input" readonly>
                     </div>
                     
                     <div class="col-md-6 modal-item">
                       <label for="docgia.ngayHetHan" class="form-label">Ngày hết hạn</label>
                       <input name="docgia.ngayHetHan" id="docgia.ngayHetHan" value="${docgiaDTO.docgia.formattedNgayHetHan}" class="form-control" type="text" placeholder="Disabled input" readonly>
                     </div>
                     
	                <div class="modal-footer">
	                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
	                  <button id="saveButton" type="submit" class="btn btn-success">Lưu</button>
	                </div>
                     
                   </form:form>   
                 </div>
                 
               </div>
             </div>
           </div>

	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
</body>
</html>