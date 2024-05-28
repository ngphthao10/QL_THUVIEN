<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
		    visibility: hidden;
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
              <h2>Đổi mật khẩu</h2>
            </div>
            <form class="form" id="form" action="home/doimatkhau.htm" method="post">
              <div class="mb-3 form-control">
                <input name="mkHT" id="mkHT" type="password" class="form-control form-control-lg bg-light mb-2" placeholder="Nhập mật khẩu hiện tại*" required>
                <i class="fa-solid fa-check"></i>
                <i class="fa-solid fa-xmark"></i>
                <small>${message }</small>
              </div>

              <div class="mb-3 form-control">
                <input name="mkMoi" id="mkMoi" type="password" class="form-control form-control-lg bg-light mb-2" placeholder="Nhập mật khẩu mới*" required>
                <i class="fa-solid fa-check"></i>
                <i class="fa-solid fa-xmark"></i>
                <small>Error message</small>
              </div>

              <div class="mb-3 form-control">
                <input name="xacnhanMKMoi" id="xacnhanMKMoi" type="password" class="form-control form-control-lg bg-light mb-2" placeholder="Xác nhận mật khẩu mới*" required>
                <i class="fa-solid fa-check"></i>
                <i class="fa-solid fa-xmark"></i>
                <small>Error message</small>
              </div>

              <div class="mb-3" style="color:red;">
                ${message}
              </div>
              <div class="mb-3 form-control">
                <button type="submit" class="btn btn-lg btn btn-warning w-100 fs-6" style="background-color: #634832; color: white;">Lưu thông tin</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <script type="text/javascript">
      document.addEventListener('DOMContentLoaded', (event) => {
        const form = document.getElementById('form');
        const mkHT = document.getElementById('mkHT');
        const mkMoi = document.getElementById('mkMoi');
        const xacnhanMKMoi = document.getElementById('xacnhanMKMoi');

        form.addEventListener('submit', (e) => {
          if (!validateInputs()) {
            e.preventDefault();
          }
        });

        function validateInputs() {
          let isValid = true;

          // Get the values from the inputs
          const mkHTValue = mkHT.value.trim();
          const mkMoiValue = mkMoi.value.trim();
          const xacnhanMKMoiValue = xacnhanMKMoi.value.trim();

          if (mkHTValue === '') {
            setErrorFor(mkHT, 'Mật khẩu hiện tại không được để trống');
            isValid = false;
          } else {
            setSuccessFor(mkHT);
          }

          if (mkMoiValue === '') {
            setErrorFor(mkMoi, 'Mật khẩu mới không được để trống');
            isValid = false;
          } else {
            setSuccessFor(mkMoi);
          }

          if (xacnhanMKMoiValue === '') {
            setErrorFor(xacnhanMKMoi, 'Xác nhận mật khẩu không được để trống');
            isValid = false;
          } else if (mkMoiValue !== xacnhanMKMoiValue) {
            setErrorFor(xacnhanMKMoi, 'Mật khẩu không khớp');
            isValid = false;
          } else {
            setSuccessFor(xacnhanMKMoi);
          }

          return isValid;
        }

        function setErrorFor(input, message) {
          const formControl = input.parentElement;
          const small = formControl.querySelector('small');
          const checkIcon = formControl.querySelector('.fa-check');
          const xmarkIcon = formControl.querySelector('.fa-xmark');

          formControl.className = 'mb-3 form-control error';
          small.innerText = message;
          small.style.visibility = 'visible';
          checkIcon.style.visibility = 'hidden';
          xmarkIcon.style.visibility = 'visible';
        }

        function setSuccessFor(input) {
          const formControl = input.parentElement;
          const small = formControl.querySelector('small');
          const checkIcon = formControl.querySelector('.fa-check');
          const xmarkIcon = formControl.querySelector('.fa-xmark');

          formControl.className = 'mb-3 form-control success';
          small.style.visibility = 'hidden';
          checkIcon.style.visibility = 'visible';
          xmarkIcon.style.visibility = 'hidden';
        }
      });
    </script>

    <jsp:include page="xacnhanDNLai.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-beta1/js/bootstrap.min.js"></script>
  </body>
</html>
