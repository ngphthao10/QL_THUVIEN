<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${message == -1}">
        <script>
        window.onload = function showModal() {
            var myModal = new bootstrap.Modal(document.getElementById('insertPhieuMuonTraModal'), {});
            myModal.show();
        }
        </script>
    </c:if>
	
	<div class="modal fade" id="insertPhieuMuonTraModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-lg">
         <div class="modal-content">
           <div class="modal-header"  style="background-color: #5f4935; color: #fff;">
             <h1 class="modal-title fs-5 " id="exampleModalLabel">PHIẾU MƯỢN TRẢ</h1>
             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
           </div>
           <div class="modal-body" style="background-color: #eae0d2;">
             <form:form class="row g-3 needs-validation" action = "${pageContext.request.contextPath}/phieumuontra/listPhieuMuonTra.htm?insert" modelAttribute="phieumuontra" method="post">
             	
             	<div class="row p-4" style="margin: auto;">
             		
             		<div class="col-md-6">
	                    <label class="form-label" for="cuonSach.maCuonSach"><h6>Mã cuốn sách</h6></label>
	                    <input class="form-control" name="cuonSach.maCuonSach" required/>
	                    <div class="invalid-feedback">
							<form:errors path="cuonSach.maCuonSach" cssClass="form-error" ></form:errors>
	                    </div>
	                </div>
	                
	                <div class="col-md-6">
	                    <label class="form-label" for="docGia.maDocGia"><h6>Mã độc giả</h6></label>
	                    <input class="form-control" name="docGia.maDocGia" required/>
	                    <div class="invalid-feedback">
							<form:errors path="docGia.maDocGia" cssClass="form-error" ></form:errors>
	                    </div>
                    </div>
	                    
	                <div class="col-md-6">
	                    <label class="form-label" for="ngayMuon"><h6>Ngày mượn</h6></label>
	                    <input class="form-control" type="text" name="ngayMuon" id="ngayMuon" readonly>
	                </div>
		                
	                <div class="col-md-6">
	                    <label class="form-label" for="hanTra"><h6>Hạn trả</h6></label>
	                    <input class="form-control" type="text" name="hanTra" id="hanTra" readonly/>
	                </div>

	            </div>
 
	            
	            <div class="col-12" style="text-align: right; margin-top: 0px;">
	                 <button class="btn btn-success" type="submit">Lưu thông tin</button>
	                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	            </div>
	            <input type="hidden" id="songaymuontoida" value="${songaymuontoida}" />

             </form:form>
                 
         </div>  
                   
                       
		</div>
     </div>                  
	</div>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	<script>
	    /* document.addEventListener("DOMContentLoaded", function() {
	        var songaymuontoida = document.getElementById('songaymuontoida').value;
	        
	        var ngayMuonInput = document.getElementById('ngayMuon');
	        var hanTraInput = document.getElementById('hanTra');
	
	        if (ngayMuonInput) {
	            // Đặt giá trị mặc định cho ngày mượn khi trang được tải
	            var value = moment().format('DD/MM/YYYY');
	            ngayMuonInput.value = value;
	
	            // Tính toán và đặt giá trị cho hạn trả khi trang được tải
	            if (hanTraInput) {
	                var hanTraDateTime = moment().add(parseInt(songaymuontoida), 'days').format('DD/MM/YYYY');
	                hanTraInput.value = hanTraDateTime;
	            }
	        }
	    }); */
	    
	    $(document).ready(function() {
	        $('#insertPhieuMuonTraModal').on('show.bs.modal', function (event) {
	            var songaymuontoida = document.getElementById('songaymuontoida').value;
	            
	            var ngayMuonInput = document.getElementById('ngayMuon');
	            var hanTraInput = document.getElementById('hanTra');

	            if (ngayMuonInput) {
	                // Đặt giá trị mặc định cho ngày mượn khi modal được hiển thị
	                var value = moment().format('DD/MM/YYYY');
	                ngayMuonInput.value = value;

	                // Tính toán và đặt giá trị cho hạn trả khi modal được hiển thị
	                if (hanTraInput) {
	                    var hanTraDateTime = moment().add(parseInt(songaymuontoida), 'days').format('DD/MM/YYYY');
	                    hanTraInput.value = hanTraDateTime;
	                }
	            }
	        });
	    });

	</script>

	
	<!-- <script>
	
	$('#ngayMuon').change(function(){
        var ngayMuonVal = $(this).val(); // Lấy giá trị ngày mượn
        var ngayMuonDate = new Date(ngayMuonVal); // Chuyển thành đối tượng Date

        // Cộng thêm 4 ngày
        ngayMuonDate.setDate(ngayMuonDate.getDate() + 4);

        // Định dạng ngày thành chuỗi 'dd/mm/yyyy'
        var hanTraDate = ('0' + ngayMuonDate.getDate()).slice(-2) + '/' + ('0' + (ngayMuonDate.getMonth() + 1)).slice(-2) + '/' + ngayMuonDate.getFullYear();

        // Gán giá trị cho input "hanTra"
        $('#hanTra').val(hanTraDate);
    });
	</script> -->
</body>
</html>