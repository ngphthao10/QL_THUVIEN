<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="vi">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đổi mật khẩu</title>
    <script src="https://kit.fontawesome.com/e63b023844.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
      ::placeholder {
		    font-size: 16px;
		}
		
		/* Rounded Borders */
		.rounded-5 {
		    border-radius: 20px;
		}
		
		/* For small screens */
		@media only screen and (max-width: 308px) {
		    .box-area {
		        margin: 0 10px;
		    }
		}
		
		/* Header Text */
		.header-text {
		    text-align: center;
		}
		
		/* Form Controls */
		.form .form-control {
		    border-color: white;
		    padding-right: 0px;
		    padding-top: 10px;
		    position: relative;
		}
		
		/* Icons inside form controls */
		.form .form-control i {
		    position: absolute;
		    right: 10px;
		    top: 50%;
		    transform: translateY(-50%);
		    visibility: hidden;
		}
		
		/* Error Message */
		.form small {
		    position: absolute;
		    left: 10px;
		    color: #e74c3c;
		}
		
		/* Success Input */
		.form-control.success input {
		    border-color: #2ecc71;
		}
		
		/* Error Input */
		.form .form-control.error input {
		    border-color: #e74c3c;
		}
		
		/* Success Icon */
		.form .form-control.success i.fa-check {
		    color: #2ecc71;
		    visibility: visible;
		}
		
		/* Error Icon */
		.form .form-control.error i.fa-xmark {
		    color: #e74c3c;
		    visibility: visible;
        }
    </style>
  </head>
  <body>
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
      <div class="row border rounded-5 p-3 bg-white shadow">
        <div class="col-md-12">
          <div class="row align-items-center">
            <div class="header-text mb-4 mt-4">
              <h4>Nhập tên đăng nhập</h4>
            </div>
            <form class="form" id="form" action="XNUsername.htm" method="post">
			
			
              <div class="mb-3 form-control">
                <input name="username" type="text" class="form-control form-control-lg bg-light mb-2" placeholder="Nhập tên đăng nhập*" required>
                <small>${message}</small>
              </div>	
              
              <div class="mb-3 d-flex form-control">
                <button type="button" class="btn btn-lg btn btn-secondary w-100 fs-6 me-2">
                	<a href="login.htm" style="text-decoration:none; color:white;">Thoát</a>
                </button>
                <button type="submit" class="btn btn-lg btn btn-warning w-100 fs-6" style="background-color: #634832; color: white;">Tiếp tục</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

  
    <jsp:include page="xacnhanDNLai.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-beta1/js/bootstrap.min.js"></script>
  </body>
</html>
