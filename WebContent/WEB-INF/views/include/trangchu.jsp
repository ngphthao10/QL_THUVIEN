<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container">
	                <div class="row">
	                    <div class="col-7">
	                        <h3 class="mt-4" style="color: #634832;">Chào mừng đến với thư viện PTIT! </h3>
	                        <h5 class="mt-2" style="color: #634832;">${thoigian}</h5>
	                    </div>
	                    <div class="col-2 mt-4">
						    <select class="form-select" aria-label="Chọn tháng" id="monthSelect">
						        <option value="1">Tháng 1</option>
						        <option value="2">Tháng 2</option>
						        <option value="3">Tháng 3</option>
						        <option value="4">Tháng 4</option>
						        <option value="5">Tháng 5</option>
						        <option value="6">Tháng 6</option>
						        <option value="7">Tháng 7</option>
						        <option value="8">Tháng 8</option>
						        <option value="9">Tháng 9</option>
						        <option value="10">Tháng 10</option>
						        <option value="11">Tháng 11</option>
						        <option value="12">Tháng 12</option>
						    </select>
						</div>
						<div class="col-2 mt-4">
						    <select class="form-select" aria-label="Chọn năm" id="yearSelect">
						    </select>
						</div>
						
						<script>
						    const yearSelect = document.getElementById('yearSelect');
						    const currentYear = new Date().getFullYear();
						    const startYear = 2020;
						
						    for (let year = startYear; year <= currentYear; year++) {
						        let option = document.createElement('option');
						        option.value = year;
						        option.textContent = year;
						        yearSelect.appendChild(option);
						    }
						</script>

	                    <div class="col-1 mt-4" style="text-align:right;">
	                    	<button type="button" class="btn btn-outline-secondary">
	                    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-filter mb-1" viewBox="0 0 16 16">
							  <path d="M6 10.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5m-2-3a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5m-2-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5"/>
							</svg>
	                    	Lọc</button>
	                    </div>
	                </div>
	                <div class="row mt-4">
	                    <div class="col-sm-3 mb-3 mb-sm-0">
	                        <div class="card border-secondary">
	                            <div class="card-body">
	                                <div class="row">
	                                    <h2 class="col-sm-6">${soLuotMuon}</h2>
	                                    <div class="col-sm-6" style="text-align: right;">
	                                        <img width="50" height="50" src="https://img.icons8.com/wired/64/borrow-book.png" alt="borrow-book"/>                                       
	                                    </div>
	                                </div>
	                                <h4 class="card-text">Số lượt mượn.</h4>
	                                <div style="text-align: right;">
	                                    <a href="#" class="btn btn-outline-secondary" >Chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-sm-3">
	                        <div class="card border-secondary">
	                            <div class="card-body">
	                                <div class="row">
	                                    <h2 class="col-sm-6">${soLuongSach}</h2>
	                                    <div class="col-sm-6" style="text-align: right;">
	                                        <img width="50" height="50" src="https://img.icons8.com/wired/50/book.png" alt="book"/>   
	                                    </div>
	                                </div>
	                                <h4 class="card-text">Số lượng sách.</h4>
	                                <div style="text-align: right;">
	                                    <a href="sach/sach/index.htm" class="btn btn-outline-secondary">Chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-sm-3">
	                        <div class="card border-secondary">
	                            <div class="card-body">
	                                <div class="row">
	                                    <h2 class="col-sm-6">${soDocGia}</h2>
	                                    <div class="col-sm-6" style="text-align: right;">
	                                        <img width="50" height="50" src="https://img.icons8.com/external-vitaliy-gorbachev-lineal-vitaly-gorbachev/60/external-user-internet-security-vitaliy-gorbachev-lineal-vitaly-gorbachev.png" alt="external-user-internet-security-vitaliy-gorbachev-lineal-vitaly-gorbachev"/>                                </div>
	                                    </div>
	                                <h4 class="card-text">Số độc giả.</h4>
	                                <div style="text-align: right;">
	                                    <a href="#" class="btn btn-outline-secondary">Chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-sm-3">
	                        <div class="card border-secondary">
	                            <div class="card-body">
	                                <div class="row">
	                                    <h2 class="col-sm-6">${muonQuaHan}</h2>
	                                    <div class="col-sm-6" style="text-align: right;">
	                                        <img width="50" height="50" src="https://img.icons8.com/dotty/80/important-time.png" alt="important-time"/>                                    </div>
	                                </div>
	                                <h4 class="card-text">Mượn quá hạn.</h4>
	                                <div style="text-align: right;">
	                                    <a href="#" class="btn btn-outline-secondary">Chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="card-group mt-4">
	                    <div class="card border-secondary">
	                        <h5 class="card-header bg-transparent">Danh sách tựa sách</h5>
	                        <div class="card-body">
	                            <table class="table table-sm table-hover">
	                                <thead>
	                                    <tr>
	                                       	<th class="centered-column" scope="col">Mã</th>
											<th class="centered-column" scope="col">Tên tựa sách</th>
											<th class="centered-column" scope="col">Tác giả</th>
	                                    </tr>
	                                </thead>
	                                <tbody class="table-group-divider">
	                                	<c:forEach begin="0" end="5" var="p" items="${tuasachList}">
											<tr>
												<td>${p.maTuaSach}</td>
												<td>${p.tenTuaSach}</td>
												<td>${p.getTacGia()}</td>
											</tr>
										</c:forEach>
	                                </tbody>
	                            </table>
	                            <div class="text-end">
	                                <a class="link-danger link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover" href="sach/tuasach/index.htm">
	                                    Xem tất cả
	                                </a>
	                            </div>   
	                        </div>
	                    </div>
	                    <div class="card border-secondary">
	                        <h5 class="card-header bg-transparent">Danh sách độc giả</h5>
	                        <div class="card-body">
	                            <table class="table table-sm table-hover">
	                                <thead>
	                                    <tr>
	                                       	<th class="centered-column" scope="col">Mã</th>
											<th class="centered-column" scope="col">Tên độc giả</th>
											<th class="centered-column" scope="col">Ngày sinh</th>
											<th class="centered-column" scope="col">Ngày lập thẻ</th>
											<th class="centered-column" scope="col">Ngày hết hạn</th>
	                                    </tr>
	                                </thead>
	                                <tbody class="table-group-divider">
	                                	<c:forEach begin="0" end="5" var="p" items="${docgiaList}">
											<tr>
												<td>${p.maDocGia}</td>
												<td>${p.tenDocGia}</td>
												<td class="centered-column">${p.ngaySinh}</td>
												<td class="centered-column">${p.ngayLapThe}</td>
												<td class="centered-column">${p.ngayHetHan}</td>
											</tr>
										</c:forEach>
	                                </tbody>
	                            </table>
	                            <div class="text-end">
	                                <a class="link-danger link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover" href="#">
	                                    Xem tất cả
	                                </a>
	                            </div>   
	                        </div>
	                    </div>
                	</div>
            	</div>
			</div>
		</div>
	</div>
</body>
</html>
