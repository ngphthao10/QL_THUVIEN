<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	.invalid-feedback {
			display: block;
			margin-top: 5px;
			margin-bottom: 5px
		}
	</style>
</head>
<body>

	<c:if test="${showModalEdit || message1 == -1}">
        <script>
	        window.onload = function showModal() {
	            var myModal = new bootstrap.Modal(document.getElementById('editPhieuMuonTraModal'), {});
	            myModal.show();
	        }
        </script>
    </c:if>
	
	<div class="modal fade" id="editPhieuMuonTraModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-lg">
         <div class="modal-content">
           <div class="modal-header"  style="background-color: #5f4935; color: #fff;">
             <h1 class="modal-title fs-5 " id="exampleModalLabel">PHIẾU MƯỢN TRẢ</h1>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           <div class="modal-body" style="background-color: #eae0d2;">
             <form:form class="row g-3 needs-validation" action = "${pageContext.request.contextPath}/phieumuontra/listPhieuMuonTra.htm?edit" modelAttribute="phieumuontra" method="post">
             	
             	<div class="row p-4" style="margin: auto;">
             		
             		<div class="col-6">
             			<div class="row-label"><h5>Thông tin cuốn sách</h5></div>
             			
             			<div class="col-md-12">
		                    <label class="form-label" for="cuonSach.MaCuonSach"><h6>Mã cuốn sách</h6></label>
		                    <input class="form-control" name="cuonSach.MaCuonSach" value="${phieumuontra.cuonSach.maCuonSach }" />
		                    <div class="invalid-feedback">
								<form:errors path="cuonSach.MaCuonSach" cssClass="form-error" ></form:errors>
		                    </div>
		                </div>
	                    
	                    <div class="col-md-12">
		                    <label class="form-label" for="cuonSach.sach1.tuaSach1.TenTuaSach"><h6>Tên cuốn sách</h6></label>
		                    <input class="form-control" name="cuonSach.sach1.tuaSach1.TenTuaSach" value="${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach }" readonly/>
		                    <div class="invalid-feedback">
								
		                    </div>
		                </div>
	                    
	                    <div class="col-md-12">
		                    <label class="form-label" for="cuonSach.sach1.tuaSach1.theloai.TenTheLoai"><h6>Thể loại</h6></label>
		                    <input class="form-control" name="cuonSach.sach1.tuaSach1.theloai.TenTheLoai" value="${phieumuontra.cuonSach.sach1.tuaSach1.theloai.tenTheLoai }" readonly/>
		                    <div class="invalid-feedback">

	                    	</div>
	                  </div>
	                    
	                 </div>
	                 
	                 <div class="col-6">
	                 	<div class="row-label"><h5>Thông tin độc giả</h5></div>
	                 	
	                 	<div class="col-md-12">
		                    <label class="form-label" for="docGia.maDocGia"><h6>Mã độc giả</h6></label>
		                    <input class="form-control" name="docGia.maDocGia" value="${phieumuontra.docGia.maDocGia }" />
		                    <div class="invalid-feedback">
								<form:errors path="docGia.maDocGia" cssClass="form-error" ></form:errors>
		                    </div>
	                    </div>
	                    
	                     <div class="col-md-12">
		                    <label class="form-label" for="docGia.tenDocGia"><h6>Họ tên</h6></label>
		                    <input class="form-control" name="docGia.tenDocGia" value="${phieumuontra.docGia.tenDocGia }" readonly/>
		                    <div class="invalid-feedback">
	
		                    </div>
		                 </div>
		                 
		                 <div class="col-md-12">
		                    <label class="form-label" for="docGia.tongNoHienTai"><h6>Tổng nợ hiện tại</h6></label>
		                    <input class="form-control" name="docGia.tongNoHienTai" value="${phieumuontra.docGia.tongNoHienTai }" readonly/>
		                    <div class="invalid-feedback">
		
		                    </div>
		                 </div>
	                    
	                 </div>
	            </div>
	            
	            <div class="w-100 d-none d-md-block"><hr></div>
	            
	            <div class="row p-4" style="margin: auto;">
	            	
	            	<label class = "row-label"><h5>Chi tiết mượn trả</h5></label>
	            	<div class="col-6">
	            		
	            		<div class="col-md-12">
		                    <label class="form-label" for="ngayMuon"><h6>Ngày mượn</h6></label>
		                    <input class="form-control" name="ngayMuon" id="ngaymuon" value="<fmt:formatDate value="${phieumuontra.ngayMuon}" pattern="dd/MM/yyyy"/>"/>
		                    <div class="invalid-feedback">
	
		                    </div>
		                </div>
		                
		                <div class="col-md-12">
		                    <label class="form-label" for="hanTra"><h6>Hạn trả</h6></label>
		                    <input class="form-control" name="hanTra" id="hantra" value="<fmt:formatDate value="${phieumuontra.hanTra}" pattern="dd/MM/yyyy"/>"/>
		                    <div class="invalid-feedback">
	
		                    </div>
		                </div>
		                
		                <div class="col-md-12">
		                    <label class="form-label" for="ngayTra"><h6>Ngày trả</h6></label>
		                    <input class="form-control datepicker" name="ngayTra" id="ngaytra" value="<fmt:formatDate value="${phieumuontra.ngayTra}" pattern="dd/MM/yyyy"/>"/>
		                    <div class="invalid-feedback">
								<form:errors path="ngayTra" cssClass="form-error" ></form:errors>
		                    </div>
		                </div>
	            		
	            	</div>
	            	
	            	<div class="col-6">
	            	
	            		<div class="col-md-12">
		                    <label class="form-label" for="songaytratre"><h6>Số ngày trả trễ</h6></label>
		                    <input class="form-control" name="songaytratre" value="${songaytratre }" readonly/>
		                    <div class="invalid-feedback">
	
		                    </div>
		               	</div>
		               	
		               	<div class="col-md-12">
		                    <label class="form-label" for="dongiaphat"><h6>Đơn giá phạt</h6></label>
		                    <input class="form-control" name="dongiaphat"/ value="${dongiaphat }" readonly>
		                    <div class="invalid-feedback">
								
		                    </div>
		                </div>
		                 
		                 <div class="col-md-12">
		                    <label class="form-label" for="tienphat"><h6>Tiền phạt</h6></label>
		                    <input class="form-control" name="tienphat" value="${tienphat }" readonly/>
		                    <div class="invalid-feedback">
	
		                    </div>
		                 </div>
		                 
		                 <div class="col-md-12">
		                    <label class="form-label" for="tongnomoi"><h6>Tổng nợ mới</h6></label>
		                    <input class="form-control" name="tongnomoi" value="${tongnomoi }" readonly/>
		                    <div class="invalid-feedback">

		                    </div>
		                </div>
	            	
	            	</div>
	            	
	            </div>
	            
	            <div class="col-12" style="text-align: right; margin-top: 0px;">
	                 <button class="btn btn-success" type="submit">Lưu thông tin</button>
	                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	            </div>
	            <input type="hidden" name="soPhieuMuonTra" value="${phieumuontra.soPhieuMuonTra }">

             </form:form>
                 
         </div>  
                   
                       
		</div>
     </div>                  
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	<script>
	    // Đảm bảo thư viện moment.js đã được tải trước khi sử dụng
	    /* document.addEventListener("DOMContentLoaded", function() {
	        // Lấy giá trị của input
	        var ngayMuonValue = document.getElementById('ngaymuon').value;
	        var hanTraValue = document.getElementById('hantra').value;
	        var ngayTraValue = document.getElementById('ngaytra').value;
	        
	        // Định dạng lại ngày theo dd/MM/yyyy bằng moment.js
	        var formattedNgayMuon = moment(ngayMuonValue).format('DD/MM/YYYY');
	        var formattedHanTra = moment(hanTraValue).format('DD/MM/YYYY');
	        var formattedNgayTra = moment(ngayTraValue).format('DD/MM/YYYY');
	        
	        // Gán lại giá trị đã định dạng vào input
	        document.getElementById('ngaymuon').value = formattedNgayMuon;
	        document.getElementById('hantra').value = formattedHanTra;
	        document.getElementById('ngaytra').value = formattedNgayTra;
	    }); */
	    
	    document.addEventListener("DOMContentLoaded", function() {
	        var ngayTraInput = document.getElementById('ngaytra');
	        ngayTraInput.addEventListener('change', function() {
	            var value = moment(ngayTraInput.value, 'YYYY-MM-DD').format('DD/MM/YYYY');
	            ngayTraInput.value = value;
	        });
	        var hanTraInput = document.getElementById('hantra');
	        hanTraInput.addEventListener('change', function() {
	            var value = moment(hanTraInput.value, 'YYYY-MM-DD').format('DD/MM/YYYY');
	            hanTraInput.value = value;
	        });
	        var ngayMuonInput = document.getElementById('ngaymuon');
	        ngayMuonInput.addEventListener('change', function() {
	            var value = moment(ngayMuonInput.value, 'YYYY-MM-DD').format('DD/MM/YYYY');
	            ngayMuonInput.value = value;
	        });
	    });
	</script>
</body>
</html>