<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm Phiếu Thu</title>
<style>
	.invalid-feedback {
			display: block;
			margin-top: 5px;
			margin-bottom: 5px
		}
	</style>
</head>
	
<body>
	
	<c:if test="${message == -1}">
        <script>
        window.onload = function showModal() {
            var myModal = new bootstrap.Modal(document.getElementById('insertPhieuThuModal'), {});
            myModal.show();
        }
        </script>
    </c:if>
	
	<div class="modal fade" id="insertPhieuThuModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header"  style="background-color: #5f4935; color: #fff;">
              <h1 class="modal-title fs-5" id="exampleModalLabel">Phiếu thu tiền phạt</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="background-color: #eae0d2;">
              <form:form class="row g-3 needs-validation" action = "${pageContext.request.contextPath}/phieuthu/listPhieuThu.htm?insert" modelAttribute="phieuthu" method="post">

                <div class="row p-4" style="margin: auto;">
                
                  <div class="col-md-12">
                    <label class="form-label" for="docGia.maDocGia"><h6>Mã độc giả</h6></label>
                    <input class="form-control" name="docGia.maDocGia"/>
                    <div class="invalid-feedback">
                     	<form:errors path="docGia.maDocGia" cssClass="form-error" ></form:errors>
                    </div>
                  </div>

                  <div class="col-md-12">
                    <label class="form-label" for="soTienThu"><h6>Số tiền thu</h6></label>
                    <input class="form-control" name="soTienThu"/>
                    <div class="invalid-feedback">
                    	<form:errors path="soTienThu" cssClass="form-error"></form:errors>
                    	<%-- <c:out value="${docGia.maDocGiaError }"></c:out> --%>
                    </div>
                  </div>

                  <div class="col-md-12">
                    <label class="form-label" for="ngayLap"><h6>Ngày lập</h6></label>
                    <input class="form-control" name="ngayLap" id="ngayLap" readonly/>
                  </div>
                </div>

                <div class="col-12" style="text-align: right; margin-top: 0px;">
                  <button class="btn btn-success" type="submit" id="saveButton">Lưu thông tin</button>
                  
                </div>
                <input type="hidden" name="sophieuthu" value="${phieuthu.soPhieuThu }">
              </form:form>
            </div>
            
            <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	      	</div>
            
          </div>
        </div>
      </div>
		
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>	
		
	  <script>
	    // Định nghĩa hàm xử lý sự kiện DOMContentLoaded
	    document.addEventListener("DOMContentLoaded", function() {
	        // Lấy ngày và giờ hiện tại và định dạng thành chuỗi dd/MM/yyyy
	        var formattedDateTime = moment().format('DD/MM/yyyy');
	        
	        // Gán giá trị vào ô nhập liệu	
	        var ngayLapInput = document.getElementById('ngayLap');
	        if (ngayLapInput) {
	            ngayLapInput.value = formattedDateTime;
	        }
	    });
	</script>
	
	
</body>
</html>