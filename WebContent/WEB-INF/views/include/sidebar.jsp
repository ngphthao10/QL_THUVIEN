<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sidebar</title>
<style>
.sidebar {
	background-color: #dbc1ac;
/* 	height: 100vh; */
	border-right: 1px solid snow;
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
.row .row-label {
  	text-align: center;
}
.row .form-label {
  	margin: 2px;
  	padding-top: 3px;
}
th {
	text-align: center;
	vertical-align: middle;
}

</style>
</head>
<body>
	<div class="sidebar col-md-2">
		<div class="accordion accordion-flush" id="accordionFlushExample">
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
						aria-expanded="false" aria-controls="flush-collapseOne">
						<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
							fill="currentColor" class="bi bi-people  " viewBox="0 0 16 16">
                      <path
								d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1zm-7.978-1L7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002-.014.002zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0M6.936 9.28a6 6 0 0 0-1.23-.247A7 7 0 0 0 5 9c-4 0-5 3-5 4q0 1 1 1h4.216A2.24 2.24 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816M4.92 10A5.5 5.5 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0m3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4" />
                    </svg>
						<b class="ps-2">NGƯỜI DÙNG</b>
					</button>
				</h2>
				<div id="flush-collapseOne" class="accordion-collapse collapse"
					data-bs-parent="#accordionFlushExample">
					<ul class="btn-toggle-nav list-unstyled fw-normal ps-5 medium mt-3">
						<li><a href="nguoidung/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Người dùng</h6></a></li>
						<li><a href="nhomnguoidung/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded mt-1"><h6>Nhóm người dùng</h6></a></li>
					</ul>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
						aria-expanded="false" aria-controls="flush-collapseTwo">
						<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
							fill="currentColor" class="bi bi-person-vcard"
							viewBox="0 0 16 16">
                      <path
								d="M5 8a2 2 0 1 0 0-4 2 2 0 0 0 0 4m4-2.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5M9 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4A.5.5 0 0 1 9 8m1 2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5" />
                      <path
								d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2zM1 4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H8.96q.04-.245.04-.5C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 1 1 12z" />
                    </svg>
						<b class="ps-2">ĐỘC GIẢ</b>
					</button>
				</h2>
				<div id="flush-collapseTwo" class="accordion-collapse collapse"
					data-bs-parent="#accordionFlushExample">
					<ul class="btn-toggle-nav list-unstyled fw-normal ps-5 medium mt-3">
						<li><a href="docgia/listDocGia.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Thông
									tin độc giả</h6></a></li>
						<li><a href="loaidocgia/listLoaiDocGia.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded mt-1"><h6>Loại
									độc giả</h6></a></li>
					</ul>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
						aria-expanded="false" aria-controls="flush-collapseThree">
						<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
							fill="currentColor" class="bi bi-journal-bookmark"
							viewBox="0 0 16 16">
                   			<path fill-rule="evenodd"
								d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8" />
                      		<path
								d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2" />
                      		<path
								d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z" />
                    </svg>
						<b class="ps-2">SÁCH</b>
					</button>
				</h2>
				<div id="flush-collapseThree" class="accordion-collapse collapse"
					data-bs-parent="#accordionFlushExample">
					<ul class="btn-toggle-nav list-unstyled fw-normal ps-5 medium mt-3">
						<li><a href="sach/tuasach/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Tựa sách</h6></a></li>
						<li><a href="sach/sach/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Sách</h6></a></li>
						<li><a href="sach/cuonsach/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Cuốn sách</h6></a></li>
						<li><a href="sach/theloai/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Thể
									loại</h6></a></li>
						<li><a href="sach/phieunhapsach/index.htm"
							class="link-body-emphasis d-inline-flex text-decoration-none rounded"><h6>Phiếu
									nhập sách</h6></a></li>
					</ul>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button1 collapsed" type="button" 
						data-bs-target="#flush-collapseThree" aria-expanded="false"
						aria-controls="flush-collapseThree">
						<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
							fill="currentColor" class="bi bi-receipt" viewBox="0 0 16 16">
                      		<path
								d="M1.92.506a.5.5 0 0 1 .434.14L3 1.293l.646-.647a.5.5 0 0 1 .708 0L5 1.293l.646-.647a.5.5 0 0 1 .708 0L7 1.293l.646-.647a.5.5 0 0 1 .708 0L9 1.293l.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .801.13l.5 1A.5.5 0 0 1 15 2v12a.5.5 0 0 1-.053.224l-.5 1a.5.5 0 0 1-.8.13L13 14.707l-.646.647a.5.5 0 0 1-.708 0L11 14.707l-.646.647a.5.5 0 0 1-.708 0L9 14.707l-.646.647a.5.5 0 0 1-.708 0L7 14.707l-.646.647a.5.5 0 0 1-.708 0L5 14.707l-.646.647a.5.5 0 0 1-.708 0L3 14.707l-.646.647a.5.5 0 0 1-.801-.13l-.5-1A.5.5 0 0 1 1 14V2a.5.5 0 0 1 .053-.224l.5-1a.5.5 0 0 1 .367-.27m.217 1.338L2 2.118v11.764l.137.274.51-.51a.5.5 0 0 1 .707 0l.646.647.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.509.509.137-.274V2.118l-.137-.274-.51.51a.5.5 0 0 1-.707 0L12 1.707l-.646.647a.5.5 0 0 1-.708 0L10 1.707l-.646.647a.5.5 0 0 1-.708 0L8 1.707l-.646.647a.5.5 0 0 1-.708 0L6 1.707l-.646.647a.5.5 0 0 1-.708 0L4 1.707l-.646.647a.5.5 0 0 1-.708 0z" />
                      		<path
								d="M3 4.5a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5m8-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5" />
                   		</svg>
						<a href="phieumuontra/listPhieuMuonTra.htm" 
						class="link-body-emphasis d-inline-flex text-decoration-none rounded">
							<b class="ps-2">PHIẾU MƯỢN TRẢ</b>
						</a>
					</button>
				</h2>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button1 collapsed" type="button"
						data-bs-target="#flush-collapseFour" aria-expanded="false"
						aria-controls="flush-collapseFour">
						<img width="25" height="25"
							src="https://img.icons8.com/ios/50/bank-cards--v1.png"
							alt="bank-cards--v1" /> 
						<a href="phieuthu/listPhieuThu.htm" 
						class="link-body-emphasis d-inline-flex text-decoration-none rounded">
							<b class="ps-2">PHIẾU THU</b>
						</a>
					</button>
				</h2>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button1 collapsed" type="button"
						data-bs-target="#flush-collapseFive" aria-expanded="false"
						aria-controls="flush-collapseFive">
						<img width="25" height="25"
							src="https://img.icons8.com/ios-filled/25/refresh--v2.png"
							alt="refresh--v2" />
						<a href="quydinh/index.htm" 
						class="link-body-emphasis d-inline-flex text-decoration-none rounded">
							<b class="ps-2">ĐỔI QUY ĐỊNH</b>
						</a>
					</button>
				</h2>
			</div>
		</div>
	</div>
</body>
</html>