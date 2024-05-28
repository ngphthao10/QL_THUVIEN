<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trang chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<style>
	.sidebar {
		background-color: #dbc1ac;
		min-height: 900px;
		border-right: 1px snow;
	}
	
	.bg {
		background-color: #634832;
	}
	
	.accordion {
		--bs-accordion-bg: none;
		--bs-accordion-active-bg: none;
		--bs-accordion-active-color: none;
		--bs-accordion-btn-focus-box-shadow: none;
		--bs-accordion-border-width: none;
	}
	
	.accordion-button1::after {
		flex-shrink: 0;
		height: var(--bs-accordion-btn-icon-width);
		margin-left: auto;
		content: "";
		background-image: var(--bs-accordion-btn-icon);
		background-repeat: no-repeat;
		background-size: var(--bs-accordion-btn-icon-width);
		transition: var(--bs-accordion-btn-icon-transition);
	}
	
	.accordion-button1 {
		position: relative;
		display: flex;
		align-items: center;
		width: 100%;
		padding: var(--bs-accordion-btn-padding-y)
			var(--bs-accordion-btn-padding-x);
		font-size: 1rem;
		color: var(--bs-accordion-btn-color);
		text-align: left;
		background-color: var(--bs-accordion-btn-bg);
		border: 0;
		border-radius: 0;
		overflow-anchor: none;
		transition: var(--bs-accordion-transition);
	}
	
	.button-container {
		text-align: right;
	}
	
	.button-container .modal-body {
		text-align: left;
	}
	
	.modal-content {
		background-color: #ece0d1;
	}
	
	.modal-header {
		background-color: #634832;
		color: #fff;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-richtext mb-1" viewBox="0 0 16 16">
	              	<path d="M7.5 3.75a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0m-.861 1.542 1.33.886 1.854-1.855a.25.25 0 0 1 .289-.047L11 4.75V7a.5.5 0 0 1-.5.5h-5A.5.5 0 0 1 5 7v-.5s1.54-1.274 1.639-1.208M5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5" />
	              	<path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2" />
	              	<path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z" />
	            </svg> 
	            Thư viện
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Trang chủ</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Chức năng </a>
						<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="user/trang-chu.htm">Thông tin tài khoản</a></li>
						<li><a class="dropdown-item" href="user/tra-cuu.htm">Tra cứu sách</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Các sách đã mượn</a></li>
						</ul>
					</li>
					<li class="nav-item"><a class="nav-link disabled" aria-disabled="true">Thông tin nhóm</a></li>
				</ul>
				<!-- 
				<button type="button" class="btn btn-outline-light" data-bs-toggle="modal" data-bs-target="#exampleModal">
				  	<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
					</svg>
				</button>
				 -->
				<button class="btn btn-outline-light" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
					</svg>
				</button>
			
			</div>
		</div>
	</nav>
	
	<form:form class="d-flex" role="search" method="POST" action="user/trang-chu.htm" modelAttribute="docgia">
		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
		  <div class="offcanvas-header">
		    <h5 class="offcanvas-title" id="offcanvasRightLabel">Thông tin tài khoản</h5>
		    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		  </div>
		  <div class="offcanvas-body">
		    <div class="mb-3">
		      	<label>Tên tài khoản:</label>
		        <form:input path="nguoiDung.tenDangNhap" class="form-control mt-2" readonly="true" />
	      	</div>
	      	<div class="mb-3" style="text-align:right;">
				<a class="btn btn-primary mt-2"  href="#" role="button">Đổi mật khẩu</a>
	      	</div>
	      </div>
		</div>
	</form:form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>