<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
	
	<c:if test="${showModal || message1 == -1}">
        <script>
        window.onload = function showModal() {
            var myModal = new bootstrap.Modal(document.getElementById('editPhieuThuModal'), {});
            myModal.show();
        }
        </script>
    </c:if>
	
	<div class="modal fade" id="editPhieuThuModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header"  style="background-color: #5f4935; color: #fff;">
              <h1 class="modal-title fs-5" id="exampleModalLabel">Phiếu thu tiền phạt</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="background-color: #eae0d2;">
              <form:form class="row g-3 needs-validation" action = "${pageContext.request.contextPath}/phieuthu/listPhieuThu.htm?edit" modelAttribute="phieuthu" method="post">

                <div class="row p-4" style="margin: auto;">
                
                	
                  <div class="col-md-4">
                    <label class="form-label" for="docGia.maDocGia"><h6>Mã độc giả</h6></label>
                    <input class="form-control" name="docGia.maDocGia" value="${phieuthu.docGia.maDocGia }" readonly/>
                    <div class="invalid-feedback">
                     	<form:errors path="docGia.maDocGia"></form:errors>
                    </div>
                  </div>
                  
                  <div class="col-md-8">
                    <label class="form-label" for="docGia.tenDocGia"><h6>Tên độc giả</h6></label>
                    <input class="form-control" name="docGia.tenDocGia" value="${phieuthu.docGia.tenDocGia }" readonly/>
                  </div>
                  
                  <div class="col-md-12">
                    <label class="form-label" for="docGia.tongNoHienTai"><h6>Tổng nợ hiện tại</h6></label>
                    <input class="form-control" name="docGia.tongNoHienTai" id="tongnohientai" value="${phieuthu.docGia.tongNoHienTai + phieuthu.soTienThu }"readonly/>
                  </div>

                  <div class="col-md-12">
                    <label class="form-label" for="soTienThu"><h6>Số tiền thu</h6></label>
                    <input class="form-control" name="soTienThu" id="sotienthu" value="${phieuthu.soTienThu }" />
                    <div class="invalid-feedback">
                    	<form:errors path="soTienThu" cssClass="form-error"></form:errors>
                    </div>
                  </div>
                  
                  <div class="col-md-12">
                    <label class="form-label" for="tongnomoi"><h6>Tổng nợ mới</h6></label>
                    <input class="form-control" name="tongnomoi" id="tongnomoi" value="${phieuthu.docGia.tongNoHienTai}" readonly/>
                  </div>

                  <div class="col-md-12">
                    <label class="form-label" for="ngayLap"><h6>Ngày lập</h6></label>
                    <input class="form-control" name="ngayLap" id="ngayLapEdit" value="<fmt:formatDate value="${phieuthu.ngayLap}" pattern="dd/MM/yyyy"/>" readonly/>
                    
                  </div>
                </div>
                
                <div class="col-12" style="text-align: right; margin-top: 0px;">
                  <input type="hidden" class = "soPhỉeuThu" name="soPhieuThu" value="${phieuthu.soPhieuThu }" >
                </div>

                <div class="col-12" style="text-align: right; margin-top: 0px;">
                  <button class="btn btn-success" type="submit" id="saveButton">Lưu thông tin</button>
                </div>
                
              </form:form>
            </div>
            
            <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	      	</div>
            
          </div>
        </div>
      </div>
	
	
<!-- 	<script>
	    
		 $(document).ready(function() {
	         $('#sotienthu').change(function() {
	             var sotienthuVal = parseFloat($(this).val());
	             var tongnohientaiVal = parseFloat($('#tongnohientai').val());
	
	             if (!isNaN(sotienthuVal) && !isNaN(tongnohientaiVal)) {
	                 var tongnomoi = tongnohientaiVal - sotienthuVal;
	                 $('#tongnomoi').val(tongnomoi);
	             } else {
	                 alert("Please enter valid numbers.");
	             }
	         });
	</script> -->
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script> 
	<script>
	    document.addEventListener("DOMContentLoaded", function() {
	        var ngayLapInput = document.getElementById('ngayLapEdit');
	        ngayLapInput.addEventListener('change', function() {
	            var value = moment(ngayLapInput.value, 'YYYY-MM-DD').format('DD/MM/YYYY');
	            ngayLapInput.value = value;
	        });
	    });
	</script>
	