<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="/WEB-INF/views/Header/Header.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa phiếu mượn trả</title>
</head>
<body>
	<div class="modal fade" id="xoaPhieuMuonTraModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	
		      <div class="modal-header">
		        <h1 class="modal-title fs-5">Xác nhận</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<form class="row g-3 needs-validation" action = "phieumuontra/listPhieuMuonTra.htm?delete" method="post">
			        <p>Bạn có chắc chắn muốn xóa phiếu mượn trả này không?</p>
			        <button type="submit" class="btn btn-danger">Delete</button>
			        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancel</button>
			        <input type="hidden" class = "soPhieuMuon" name="soPhieuMuon" id="soPhieuMuon" >
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
			        var id = this.closest('tr').querySelector('#soPhieuMuon').value;
			        alert(id);
			        document.querySelector('#xoaPhieuMuonTraModal #soPhieuMuon').value = id;
			    });
			});
		});
		
		
	</script>
	
	
	
</body>
</html>