<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý cuốn sách</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
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
	                  	<a style="text-decoration:none; color:black;" href="sach/cuonsach/index.htm"><h3>QUẢN LÝ CUỐN SÁCH</h3></a>
	                  </div>
	                  <div class="justify-content-end">
		                  <c:if test="${not empty message}">
							<c:choose>
								<c:when test="${message == 0}">
									<div class="alert alert-warning mt-2 me-2" role="alert">
										Sửa cuốn sách thất bại!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
								<c:when test="${message == 1}">
									<div class="alert alert-success mt-2" role="alert">
										Sửa cuốn sách thành công!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
							</c:choose>
						  </c:if>
	                  </div>
	                  <div class="d-flex justify-content-end mt-2">
						<form:form class="d-flex col-6" role="search" method="POST"
							action="sach/cuonsach/search.htm" modelAttribute="cuonsach">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Mã, tên" aria-label="Search"
								value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 120px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1"
									viewBox="0 0 16 16">
				            		<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        		</svg>
								Tìm kiếm
							</button>
						</form:form>
						<form:form class="d-flex col-6 ps-4" role="search" method="POST"
							action="sach/cuonsach/filter.htm" modelAttribute="cuonsach">
							<form:select id="selected" path="TinhTrang" class="form-select me-2">
								<form:option value="0">Chưa được mượn</form:option>
                    			<form:option value="1">Đã được mượn</form:option>
							</form:select>
							<input type="hidden" id="hidden" name="filter" value="${TinhTrang}" />
							
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
							<button class="btn btn-outline-success" style="min-width: 150px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-funnel mb-1"
									viewBox="0 0 16 16">
                      				<path
										d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                    			</svg>
								Lọc tình trạng
							</button>
						</form:form>
					</div>
                </div>
			</div>
			<div class="container">
				<!-- Khai báo pagedListHolder với param p -->
				<jsp:useBean id="pagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
				<c:choose>
						<c:when test="${not empty param.keyword }">
							<c:url value="sach/cuonsach/search.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="keyword" value="${param.keyword}" />
								
							</c:url>
						</c:when>
						<c:when test="${not empty param.filter}">
							<c:url value="sach/cuonsach/filter.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="filter" value="${param.filter}" />
								
							</c:url>
						</c:when>
						<c:otherwise>
							<c:url value="sach/cuonsach/index.htm" var="pagedLink">
								<c:param name="p" value="~" />
							</c:url>
						</c:otherwise>
					</c:choose>
				<!-- Bảng dữ liệu -->
				<table class="table align-middle table-hover table-bordered mt-4" >
					<!-- Tiêu đề -->
					<thead>
						<tr>
							  <th class="centered-column" scope="col">Mã cuốn sách</th>
		                      <th class="centered-column" scope="col">Mã sách</th>
		                      <th class="centered-column" scope="col">Tựa sách</th>
		                      <th class="centered-column" scope="col">Chỉnh sửa</th>
		                      <th class="centered-column" scope="col">Tình trạng</th>
		                      <th class="centered-column" scope="col">Ẩn sách</th>
						</tr>
					</thead>
					<!-- Dữ liệu -->
					<tbody class="table-group-divider">
						<c:forEach var="p" items="${pagedListHolder.pageList}">
							<tr>
								<td class="centered-column">${p.maCuonSach}</td>
								<td class="centered-column">${p.getMaSach() }</td>
								<td>${p.getTenTuaSach()}</td>
								<td class="centered-column"><a
									href="sach/cuonsach/index/${p.id}.htm?linkEdit">
										<button type="button" class="btn btn-outline-danger "
											onclick="showModal()">Chỉnh sửa</button>
								</a></td>
								<td class="centered-column">${p.tinhTrang}</td>
								<td class="centered-column">
								    <div>
								        <input class="form-check-input" type="checkbox" id="checkboxNoLabel${p.id}"
								         value="" aria-label="..." ${p.daAn == 1 ? 'checked' : ''} disabled	>
								    </div>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<tg:paging pagedListHolder="${pagedListHolder}"
					pagedLink="${pagedLink}" />

			</div>
			<%@include file="/WEB-INF/views/admin/sach/cuonsach/editCuonSach.jsp"%>
			<script>
			    window.onload = function() {
			        if (window.location.href.includes("linkEdit")) {
			            var myModal = new bootstrap.Modal(document.getElementById('ModalToggle'));
			            myModal.show();
			        }
			    }
			</script>	
</body>
</html>
