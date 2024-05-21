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
							<form:select path="tuaSach1.theloai.id" items="${dsTheLoai}"
								itemLabel="tenTheLoai" itemValue="id" class="form-select me-2"></form:select>
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
							<form:select path="SoLuongConLai" class="form-select me-2">
								<form:option value="1">Còn</form:option>
								<form:option value="0">Hết</form:option>
							</form:select>
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
              <table class="table table-hover table-bordered mt-4">
                <thead>
                  <tr>
                    <th scope="col" style="text-align: center;">Mã sách</th>
                    <th scope="col" style="text-align: center;">Tên sách</th>
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
							<td style="text-align: center;">${p.tuaSach1.theloai.tenTheLoai}</td>
							<td style="text-align: center;">${p.namXB}</td>
							<td style="text-align: center;">${p.nhaXB}</td>
							<td class="centered-column">${p.tuaSach1.getCTTacGia()}</td>
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
