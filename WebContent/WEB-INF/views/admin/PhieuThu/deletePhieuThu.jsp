<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="/WEB-INF/views/Header/Header.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa phiếu thu</title>
</head>
<body>
	<div class="modal fade" id="xoaPhieuThuModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	
		      <div class="modal-header">
		        <h1 class="modal-title fs-5">Xác nhận</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<form class="row g-3 needs-validation" action = "phieuthu/listPhieuThu.htm?delete" method="post">
			        <p>Bạn có chắc chắn muốn xóa phiếu thu này không?</p>
			        <button type="submit" class="btn btn-danger">Delete</button>
			        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancel</button>
			        <input type="hidden" class = "soPhỉeuThu" name="soPhieuThu" id="soPhieuThu" >
		      	</form>
		      </div>
		      	
		      <div class="modal-footer">
		        
		      </div>
	      
	    </div>
	  </div>
	</div>
	
	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function() {
			document.querySelectorAll('table .delete').forEach(function(button) {
				button.addEventListener("click", function() {
			        var id = this.closest('tr').querySelector('#soPhieuThu').value;
			        alert(id);
			        document.querySelector('#xoaPhieuThuModal #soPhieuThu').value = id;
			    });
			});
		});
		
		
	</script>
	
	
	
</body>
</html>