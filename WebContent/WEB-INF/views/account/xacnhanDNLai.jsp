<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<c:if test="${not empty showModalXN}">
        <script>
	        window.onload = function showModal() {
	            var myModal = new bootstrap.Modal(document.getElementById('xacnhanDangNhapLai'), {});
	            myModal.show();
	        }
        </script>
    </c:if>
	
	<div class="modal fade" id="xacnhanDangNhapLai" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header"  style="background-color: #5f4935; color: #fff;">
              	<h1 class="modal-title fs-5">Xác nhận</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="background-color: #eae0d2;">
              <form class="row g-3 needs-validation" action = "home/login.htm" method="post">
			        <p>Bạn đã đổi mật khẩu thành công. Vui lòng đăng nhập lại!</p>			        
			        <div class="col-12" style="text-align: right; margin-top: 0px;">
				        <button type="submit" class="btn btn-success">OK</button>
	                </div>
	                <input type="hidden" name="dangnhaplai" value="${true }">
		      	</form>
            </div>
            
          </div>
        </div>
      </div>
	
</body>
</html>