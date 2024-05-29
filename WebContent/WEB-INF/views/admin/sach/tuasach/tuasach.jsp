<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý tựa sách</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container">
					<div class="row">
						<div class="col-6 mt-4 ps-4 mt-4"> 
		                  	<a style="text-decoration:none; color:black;" href="sach/tuasach/index.htm"><h3>QUẢN LÝ TỰA SÁCH</h3></a>
						</div>
						<div class="col-6 d-grid gap-2 button-container d-md-block mt-4">
							<button class="btn btn-secondary"
								data-bs-target="#exampleModalToggle" data-bs-toggle="modal">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle mb-1" viewBox="0 0 16 16">
                        			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        			<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
                      			</svg>
								Thêm tựa sách
							</button>
							<button class="btn btn-secondary" type="button"
								data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-x-circle mb-1" viewBox="0 0 16 16">
                        			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        			<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                      			</svg>
								Quản lý tác giả
							</button>
						</div>
					</div>
					<c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm tựa sách thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm tựa sách thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message2}">
						<c:choose>
							<c:when test="${message2 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm tác giả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message2 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm tác giả thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message3}">
						<c:choose>
							<c:when test="${message3 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Sửa tựa sách thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message3 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Sửa tựa sách thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message4}">
						<c:choose>
							<c:when test="${message4 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Update tác giả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message4 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Update tác giả thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message5}">
						<c:choose>
							<c:when test="${message5 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Xóa tác giả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message5 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Xóa tác giả thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<div class="d-flex justify-content-end mt-3">
						<form:form class="d-flex col-6" role="search" method="POST"
							action="sach/tuasach/search.htm" modelAttribute="tuasachdto">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Mã, tên, tác giả" aria-label="Search" value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 120px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1" viewBox="0 0 16 16">
				            		<path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        		</svg>
								Tìm kiếm
							</button>
						</form:form>
						
						<form:form class="d-flex col-6 ps-4" role="search" method="POST"
							action="sach/tuasach/filter.htm" modelAttribute="tuasachdto">
							<%-- <select name="filter"  class="form-select me-2">
								<c:forEach var="p" items="${dsTheLoai}">
									<option value="${p.id}">${p.tenTheLoai}</option>
								</c:forEach>
							</select> --%>
							<form:select  id="selected" path="tuasach.theloai.id" items="${dsTheLoai}"
								itemLabel="tenTheLoai" itemValue="id" class="form-select me-2"></form:select>
							<input type="hidden" id="hidden" name="filter" value="${tuasach.theloai.id}" />
							
							<script>
							    const defaultOptionValue = document.getElementById('selected').options[0].value;
							    document.getElementById('hidden').value = defaultOptionValue;
							    const selectElement = document.getElementById('selected');
							    const hiddenInput = document.getElementById('hidden');
							    selectElement.addEventListener('change', function() {
							        const selectedValue = selectElement.value;
							        hiddenInput.value = selectedValue;
							    });
							</script>
							<button class="btn btn-outline-success" style="min-width: 150px;" type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-funnel mb-1" viewBox="0 0 16 16">
                      				<path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                    			</svg>
								Lọc thể loại
							</button>
						</form:form>
					</div>
				</div>
				<div class="container">

					<!-- Khai báo pagedListHolder với param p -->
					<jsp:useBean id="pagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<%-- <c:url value="sach/tuasach/index.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					 --%>
					<c:choose>
						<c:when test="${not empty param.keyword }">
							<c:url value="sach/tuasach/search.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="keyword" value="${param.keyword}" />
								
							</c:url>
						</c:when>
						<c:when test="${not empty param.filter}">
							<c:url value="sach/tuasach/filter.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="filter" value="${param.filter}" />
								
							</c:url>
						</c:when>
						<c:otherwise>
							<c:url value="sach/tuasach/index.htm" var="pagedLink">
								<c:param name="p" value="~" />
							</c:url>
						</c:otherwise>
					</c:choose>
					<!-- Bảng dữ liệu -->
					<table class="table table-hover table-bordered mt-2" style="vertical-align: middle;">
						<!-- Tiêu đề -->
						<thead>
							<tr>
								<th scope="col">Mã tựa sách</th>
								<th scope="col">Tên tựa sách</th>
								<th scope="col">Thể loại</th>
								<th scope="col">Tác giả</th>
								<th scope="col">Chức năng</th>
								<th scope="col">Ẩn tựa sách</th>
							</tr>
						</thead>
						<!-- Dữ liệu -->
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${pagedListHolder.pageList}">
								<tr>
									<td class="centered-column">${p.maTuaSach}</td>
									<td>${p.tenTuaSach}</td>
									<td class="centered-column">${p.getTenTheloai()}</td>
									<td>${p.getTacGia()}</td>
									<td class="centered-column"><a
										href="sach/tuasach/index/${p.id}.htm?linkEditTS">
											<button type="button" class="btn btn-outline-danger "
												onclick="showModal()">Chỉnh sửa</button>
									</a></td>
								    <td class="centered-column">
									    <div>
									        <input class="form-check-input" type="checkbox" id="checkboxNoLabel${p.id}" 
									        value="" aria-label="..." ${p.daAn == 1 ? 'checked' : ''} disabled>
									    </div>
									</td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />

				</div>
			</div>
			


			<%@include file="/WEB-INF/views/admin/sach/tuasach/quanlyTacGia.jsp"%>
 			<%@include file="/WEB-INF/views/admin/sach/tuasach/insertTuaSach.jsp"%>
 			<%@include file="/WEB-INF/views/admin/sach/tuasach/editTuaSach.jsp"%>
			<%@include file="/WEB-INF/views/admin/sach/tuasach/editTacGia.jsp"%>
		 	<%@include file="/WEB-INF/views/admin/sach/tuasach/delTacGia.jsp"%>

			<script>
				function addAuthorToTextarea() {
					var selectBox = document.getElementById("tacGiaSelect");
					var textarea = document
							.getElementById("selectedAuthorsTextarea");
					var selectedOption = selectBox.options[selectBox.selectedIndex];
					var selectedAuthor = selectedOption.text;
					var idAuthor = selectedOption.value; // Lấy giá trị idAuthor từ thuộc tính value của option đã chọn
					textarea.value += selectedAuthor + "\n";

					// Cập nhật giá trị của hidden input
					var hiddenInput = document
							.querySelector("input[name='selectedAuthors']");
					hiddenInput.value += idAuthor + ","; //Thêm idAuthor vào hidden input
				}
			</script>

			<script>
				function addAuthorToTextareaEdit() {
					var selectBox = document.getElementById("chonTacGia");
					var textarea = document.getElementById("tacGiaDaChon");
					var selectedOption = selectBox.options[selectBox.selectedIndex];
					var selectedAuthor = selectedOption.text;
					var idAuthor = selectedOption.value; // Lấy giá trị idAuthor từ thuộc tính value của option đã chọn
					textarea.value += selectedAuthor + "\n";

					// Cập nhật giá trị của hidden input
					var hiddenInput = document
							.querySelector("input[name='dsTacGiaDaChon']");
					hiddenInput.value += idAuthor + ","; //Thêm idAuthor vào hidden input
				}
			</script>
			<script>
			    window.onload = function() {
			        if (window.location.href.includes("linkEditTS")) {
			            var myModal = new bootstrap.Modal(document.getElementById('ModalToggle'));
			            myModal.show();
			        }
			
			        if (window.location.href.includes("linkEditTG")) {
			            var myModalEditTG = new bootstrap.Modal(document.getElementById('ModalEditTG'));
			            myModalEditTG.show();
			        }
			        if (window.location.href.includes("linkDeleteTG")) {
			            var myModalDelTG = new bootstrap.Modal(document.getElementById('ModalDelTG'));
			            myModalDelTG.show();
			        }
			    }
			</script>

</body>
</html>
