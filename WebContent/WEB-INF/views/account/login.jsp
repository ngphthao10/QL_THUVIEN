<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %>
<!doctype html>
<html lang="vi">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://www.google.com/recaptcha/api.js?hl=en"></script>
    <style>
      body{
            font-family: 'Poppins', sans-serif;
            background: #ececec;
        }
        /*------------ Login container ------------*/
        .box-area{
            width: 930px;
        }
        /*------------ Right box ------------*/
        .right-box{
            padding: 40px 30px 40px 40px;
        }
        /*------------ Custom Placeholder ------------*/
        ::placeholder{
            font-size: 16px;
        }
        .rounded-4{
            border-radius: 20px;
        }
        .rounded-5{
            border-radius: 30px;
        }
        /*------------ For small screens------------*/
        @media only screen and (max-width: 768px){
            .box-area{
                margin: 0 10px;
            }
            .left-box{
                height: 100px;
                overflow: hidden;
            }
            .right-box{
                padding: 20px;
            }
        }
    </style>
  </head>
  <body>
	
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
         <div class="row border rounded-5 p-3 bg-white shadow box-area">
         <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #dbc1ac;">
             <div class="featured-image mb-3">
              <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8"/>
                <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2"/>
                <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z"/>
              </svg>
             </div>
             <p class="text-black fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">PTIT Library</p>
             <small class="text-black text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Quản lý thư viện</small>
         </div> 
          
         <div class="col-md-6 right-box">
            <div class="row align-items-center">
                  <div class="header-text mb-3">
                       <h2>Đăng nhập</h2>
                       <p>Chào mừng bạn quay lại với Thư viện PTITHCM.</p>
                  </div>
                  <form action="home/login.htm" method="post" id="form-login">
                    <div class="input-group mb-3">
                        <input name = "tendangnhap" type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Tên đăng nhập">
                    </div>
                    <div class="input-group mb-3">
                        <input name = "matkhau" type="password" class="form-control form-control-lg bg-light fs-6" placeholder="Mật khẩu">
                    </div>
                    
                    <div class="mb-3" style="color:red;">
                        ${message }
                    </div>
                    
                   	<div class="g-recaptcha mb-3" data-callback="recaptchaCallback"
                   	data-sitekey="6LfYDOQpAAAAAFFMDTMGdXzPQedIqR2c5y_ieTUw">
                   		
                   	</div>
                    <!-- <div class="input-group mb-5 d-flex justify-content-between">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="formCheck">
                            <label for="formCheck" class="form-check-label text-secondary"><small>Ghi nhớ tôi</small></label>
                        </div>
                        <div class="forgot">
                            <small><a href="#">Quên mật khẩu?</a></small>
                        </div>
                    </div> -->
                    <div class="input-group mb-3 mt-3">
                        <button class="btn btn-lg btn btn-secondary w-100 fs-6" style="background-color: #634832;" id="submitBtn">Đăng nhập</button>
                    </div>
                  </form>
            </div>
         </div> 
        </div>
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  	
  	<script>
        function recaptchaCallback() {
            document.getElementById('submitBtn').disabled = false;
        }

        document.getElementById('form-login').addEventListener('submit', function(e) {
            if (grecaptcha.getResponse() === "") {
                e.preventDefault();
                alert("Vui lòng xác nhận reCaptcha!");
            }
        });
    </script>
	  
  </body>
</html>