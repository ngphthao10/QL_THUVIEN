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
<title>Thông tin độc giả</title>
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	
	<div class="container-fluid">
      <div class="row">
		<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
		
		<div class = "main-content col-md-10" >
          <div class="row mt-2">
            <div class="col-6 mt-4 ps-4 mt-4"><h3>THÔNG TIN ĐỘC GIẢ</h3></div>
          </div>
          
          <c:if test="${not empty message}">
			<c:choose>
				<c:when test="${message == 0}">
					<div class="alert alert-warning mt-2" role="alert">
						Sửa thông tin thất bại!
						<button type="button" class="btn-close" style="float: right;"
							data-bs-dismiss="alert" aria-label="Close"></button>
						<div>${errorMessage}</div>
					</div>
					
				</c:when>
				<c:when test="${message == 1}">
					<div class="alert alert-success mt-2" role="alert">
						Sửa thông tin thành công!
						<button type="button" class="btn-close" style="float: right;"
							data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:when>
			</c:choose>
		</c:if> 
          
          <div class="container" id="btnThongTin">
            <table class="table table-hover table-bordered mt-4">
              <tr >
                <th class="col-4" style="text-align:left;">Mã độc giả</th>
                <td>${docgiaDTO.docgia.maDocGia}</td>
              </tr>
              
              <tr>
                <th class="col-4" style="text-align:left;">Họ tên</th>
                <td>${docgiaDTO.docgia.tenDocGia}</td>
              </tr>
              
              <tr>
                <th class="col-4" style="text-align:left;">Ngày sinh</th>
                <td>${docgiaDTO.docgia.formattedNgaySinh}</td>
              </tr>

              <tr> 
                <th class="col-4" style="text-align:left;">Loại độc giả</th>
                <td>${docgiaDTO.docgia.loaiDocGia.tenLoaiDocGia}</td>
              </tr>

              <tr>
                <th class="col-4" style="text-align:left;">Địa chỉ</th>
                <td>${docgiaDTO.docgia.diaChi}</td>
              </tr>

              <tr>
                <th class="col-4" style="text-align:left;">Email</th>
                <td>${docgiaDTO.docgia.email}</td>
              </tr>

              <tr>
                <th class="col-4" style="text-align:left;">Ngày lập thẻ</th>
                <td>${docgiaDTO.docgia.formattedNgayLapThe}</td>
              </tr>

              <tr>
                <th class="col-4" style="text-align:left;">Ngày hết hạn</th>
                <td>${docgiaDTO.docgia.formattedNgayHetHan}</td>
              </tr>

              <tr>
                <th class="col-4" style="text-align:left;">Tổng nợ hiện tại</th>
                <td>${docgiaDTO.docgia.tongNoHienTai}</td>
              </tr>

            </table>
          </div>
          
          <div class="row">
  			<div class="col-auto ms-auto">
	          <div class="button-container">
	            <button class="btn btn-secondary" style="margin-right: 12px" type="button" data-bs-toggle="modal" data-bs-target="#editThongTinDGModal">Sửa thông tin</button>
	            
	            <%@include file="/WEB-INF/views/admin/docgia/editThongTin.jsp"%>
	         
	          </div>
          	</div>
	      </div>
          
          <div class="row mt-2">
            <div class="col-6 mt-4 ps-4 mt-4"><h3>SÁCH ĐANG MƯỢN</h3></div>
          </div>
          
          <div class="container">
            <table class="table table-hover table-bordered mt-4">
              <thead>
                <tr align="center">
                  <th scope="col" class="col-1">Số phiếu mượn</th>
                  <th scope="col" class="col-">Mã cuốn sách</th>
                  <th scope="col" class="col-6">Tên sách</th>
                  <th scope="col" class="col-2">Ngày mượn</th>
                  <th scope="col" class="col-2">Hạn trả</th>
                </tr>
              </thead>
              <tbody class="table-group-divider">
             
              	<c:forEach var="phieumuontra" items="${listSach_DangMuon}">
	                <tr>
	                  <th scope="row" class="text-center">${phieumuontra.soPhieuMuonTra}</th>
	                  <td class="text-center">${phieumuontra.cuonSach.maCuonSach}</td>
	                  <td>${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach}</td>
	                  <td class="text-center">${phieumuontra.formattedNgayMuon}</td>
	                  <td class="text-center">${phieumuontra.formattedHanTra}</td>
	                </tr>
                </c:forEach>
                
              </tbody>
            </table>
          </div>
          
          <div class="row mt-2">
            <div class="col-6 mt-4 ps-4 mt-4"><h3>SÁCH ĐÃ MƯỢN</h3></div>
          </div>
		  
		  <div class="row g-3 align-items-center justify-content-end">
			  <div class="col-auto">
			    <label for="inputSoSachDaMuon" class="col-form-label">Số sách đã mượn: </label>
			  </div>
			  <div class="col-auto">
			  	<div class="col-5">
			    	<input type="text" id="soSachDaMuon" value="${soSachDaMuon}" class="form-control text-center" >
				</div>
				</div>
			</div>
          
          <div class="container">
          	<jsp:useBean id="pagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
				<c:url value="docgia/thongtinDG.htm?id=${id}" var="pagedLink">
					<c:param name="p" value="~" />
				</c:url>
            <table class="table table-hover table-bordered mt-4">
              <thead>
                <tr align="center">
                  <th scope="col" class="col-1">Số phiếu mượn</th>
                  <th scope="col" class="col-1">Mã cuốn sách</th>
                  <th scope="col" class="col-5">Tên sách</th>
                  <th scope="col" class="col-2">Ngày mượn</th>
                  <th scope="col" class="col-2">Ngày trả</th>
                  <th scope="col" class="col-1">Tiền phạt</th>
                </tr>
              </thead>
              <tbody class="table-group-divider">
             
              	<c:forEach var="phieumuontra" items="${pagedListHolder.pageList}">
	                <tr>
	                  <th scope="row" class="text-center">${phieumuontra.soPhieuMuonTra}</th>
	                  <td class="text-center">${phieumuontra.cuonSach.maCuonSach}</td>
	                  <td>${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach}</td>
	                  <td class="text-center">${phieumuontra.formattedNgayMuon}</td>
	                  <td class="text-center">${phieumuontra.formattedNgayTra}</td>
	                  <td class="text-center">${phieumuontra.soTienPhat}</td>
	                </tr>
                </c:forEach>
                
              </tbody>
            </table>
            <tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
          </div>
        </div>
		
	  </div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
</body>
</html>