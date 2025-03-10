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
<title>Trang chủ</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
</head>
<body>
	<%@include file="/WEB-INF/views/user/userNavbar.jsp"%>
	<div class="container-fluid">
        <div class="row">
              <div class="main-content col-md-12">
                <div class="container">
                    <div class="row mt-4">
                        <div class="col-6">
                            <h3>Tra cứu sách</h3>
                        </div>
                        <div class="col-6 ps-4 mt-2">
                            <form:form class="d-flex" role="search" method="POST"
							action="user/tra-cuu/search.htm" modelAttribute="sach">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Mã, tên, năm xuất bản, nhà xuất bản"
								aria-label="Search" value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 150px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1"
									viewBox="0 0 16 16">
				            		<path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        		</svg>
								Tìm kiếm
							</button>
							</form:form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6"></div>
                        <div class="col-6 ps-4 mt-2">
	                        <form:form class="d-flex" role="search" method="POST"
								action="user/tra-cuu/filterTL.htm" modelAttribute="sach">
								<form:select  id="selected" path="tuaSach1.theloai.id" items="${dsTheLoai}"
									itemLabel="tenTheLoai" itemValue="id" class="form-select me-2"></form:select>
								<input type="hidden" id="hidden" name="filter" value="${tuaSach1.theloai.id}" />
								
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
                    <div class="row">
                        <div class="col-6"></div>
                        <div class="col-6 ps-4 mt-2">
                            <form:form class="d-flex" role="search" method="POST"
							action="user/tra-cuu/filterTT.htm" modelAttribute="sach">
								<form:select id="selected1" path="SoLuongConLai" class="form-select me-2">
									<form:option value="1">Còn</form:option>
									<form:option value="0">Hết</form:option>
								</form:select>
								<input type="hidden" id="hidden1" name="filterSL" value="${SoLuongConLai}" />
								<script>
								    const defaultOptionValue1 = document.getElementById('selected1').options[0].value;
								    document.getElementById('hidden1').value = defaultOptionValue1;
								    const selectElement1 = document.getElementById('selected1');
								    const hiddenInput1 = document.getElementById('hidden1');
								    selectElement.addEventListener('change', function() {
								        const selectedValue1 = selectElement1.value;
								        hiddenInput1.value = selectedValue1;
								    });
								</script>
								<button class="btn btn-outline-success" style="min-width: 150px;"
									type="submit">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-funnel mb-1"
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
				<c:url value="user/tra-cuu.htm" var="pagedLink">
					<c:param name="p" value="~" />
				</c:url>
				<c:choose>
						<c:when test="${not empty param.keyword }">
							<c:url value="user/tra-cuu/search.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="keyword" value="${param.keyword}" />
								
							</c:url>
						</c:when>
						<c:when test="${not empty param.filter}">
							<c:url value="user/tra-cuu/filterTL.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="filter" value="${param.filter}" />
								
							</c:url>
						</c:when>
						<c:when test="${not empty param.filterSL}">
							<c:url value="user/tra-cuu/filterTT.htm" var="pagedLink">
								<c:param name="p" value="~" />
								<c:param name="filterSL" value="${param.filterSL}" />
							</c:url>
						</c:when>
						<c:otherwise>
							<c:url value="user/tra-cuu.htm" var="pagedLink">
								<c:param name="p" value="~" />
							</c:url>
						</c:otherwise>
					</c:choose>
              <table class="table table-hover table-bordered mt-4">
                <thead>
                  <tr>
                    <th scope="col" style="text-align: center;">Mã sách</th>
                    <th scope="col" style="text-align: center;">Tên sách</th>
                    <th scope="col" style="text-align: center;">Hình ảnh</th>
                    <th scope="col" style="text-align: center;">Thể loại</th>
                    <th scope="col" style="text-align: center;">Năm XB</th>
                    <th scope="col" style="text-align: center;">NXB</th>
                    <th scope="col" style="text-align: center;">Tác giả</th>
                    <th scope="col" style="text-align: center;">Tình trạng</th>
                  </tr>
                </thead>
                <tbody class="table-group-divider">
					<c:forEach var="p" items="${pagedListHolder.pageList}">
						<tr>
							<td style="text-align: center;">${p.maSach}</td>
							<td>${p.tuaSach1.tenTuaSach}</td>
							<td class="centered-column"><img src="public/images/sach/${p.hinhAnh}" style="width: 70px; height: 90px;"></td>
							<td style="text-align: center;">${p.tuaSach1.theloai.tenTheLoai}</td>
							<td style="text-align: center;">${p.namXB}</td>
							<td style="text-align: center;">${p.nhaXB}</td>
							<td class="centered-column">${p.tuaSach1.getTacGia()}</td>
							<td style="text-align: center;">${p.getTinhTrang()}</td>
						</tr>
					</c:forEach>
                </tbody>
              </table>
              <tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
            </div>
          </div>
    </div>   

	
	
</body>
</html>
