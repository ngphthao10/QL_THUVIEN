<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title> Xác nhận OTP </title>
      <style>
        .otp-field {
            flex-direction: row;
            column-gap: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            }

            .otp-field input {
            height: 45px;
            width: 42px;
            border-radius: 6px;
            outline: none;
            font-size: 1.125rem;
            text-align: center;
            border: 1px solid #ddd;
            }
            .otp-field input:focus {
            box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
            }
            .otp-field input::-webkit-inner-spin-button,
            .otp-field input::-webkit-outer-spin-button {
            display: none;
            }

            .resend {
            font-size: 12px;
            }


      </style>
      <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>
   </head>
   <body class="container-fluid bg-body-tertiary d-block">
    <div class="row justify-content-center">
        <div class="col-12 col-md-6 col-lg-4" style="min-width: 500px;">
          <div class="card bg-white mb-5 mt-5 border-0" style="box-shadow: 0 12px 15px rgba(0, 0, 0, 0.02);">
          <form action="xacnhanOTP.htm" method="post">
          
            <div class="card-body p-5 text-center">
              <h4>Xác nhận OTP</h4>
              
              <div class="alert alert-success mt-2" role="alert">
				${message}	
				<button type="button" class="btn-close" style="float: right;"
					data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
			  ${message}	
              <div class="otp-field mb-4">
                <input type="number" name = "input1"/>
                <input type="number" name = "input2" disabled />
                <input type="number" name = "input3" disabled />
                <input type="number" name = "input4" disabled />
                <input type="number" name = "input5" disabled />
                <input type="number" name = "input6" disabled />
              </div>

              <button class="btn btn-primary mb-3">
                Xác nhận
              </button>
              <input type="hidden" name="otp" value = "${otp }">
              

              <p class="resend text-muted mb-0">
                Chưa nhận được mã? <a href="home/xacnhanOTP.htm?username=${username}">Gửi lại</a>
              </p>
            </div>
          </form>
          </div>
        </div>
      </div>

	<script>
	    const inputs = document.querySelectorAll(".otp-field > input");
	    const button = document.querySelector(".btn");
	
	    window.addEventListener("load", () => inputs[0].focus());
	    button.setAttribute("disabled", "disabled");
	
	    inputs[0].addEventListener("paste", function (event) {
	
	    const pastedValue = (event.clipboardData || window.clipboardData).getData(
	        "text"
	    );
	    const otpLength = inputs.length;
	
	    for (let i = 0; i < otpLength; i++) {
	        if (i < pastedValue.length) {
	        inputs[i].value = pastedValue[i];
	        inputs[i].removeAttribute("disabled");
	        inputs[i].focus;
	        } else {
	        inputs[i].value = ""; // Clear any remaining inputs
	        inputs[i].focus;
	        }
	    }
	    });
	
	    inputs.forEach((input, index1) => {
	    input.addEventListener("keyup", (e) => {
	        const currentInput = input;
	        const nextInput = input.nextElementSibling;
	        const prevInput = input.previousElementSibling;
	
	        if (currentInput.value.length > 1) {
	        currentInput.value = "";
	        return;
	        }
	
	        if (
	        nextInput &&
	        nextInput.hasAttribute("disabled") &&
	        currentInput.value !== ""
	        ) {
	        nextInput.removeAttribute("disabled");
	        nextInput.focus();
	        }
	
	        if (e.key === "Backspace") {
	        inputs.forEach((input, index2) => {
	            if (index1 <= index2 && prevInput) {
	            input.setAttribute("disabled", true);
	            input.value = "";
	            prevInput.focus();
	            }
	        });
	        }
	
	        button.classList.remove("active");
	        button.setAttribute("disabled", "disabled");
	
	        const inputsNo = inputs.length;
	        if (!inputs[inputsNo - 1].disabled && inputs[inputsNo - 1].value !== "") {
	        button.classList.add("active");
	        button.removeAttribute("disabled");
	
	        return;
	        }
	    });
	    });
	</script>
	<script>
	    let timerOn = true;
	
	    function timer(remaining) {
	    var m = Math.floor(remaining / 60);
	    var s = remaining % 60;
	    
	    m = m < 10 ? '0' + m : m;
	    s = s < 10 ? '0' + s : s;
	    document.getElementById('timer').innerHTML = m + ':' + s;
	    remaining -= 1;
	    
	    if(remaining >= 0 && timerOn) {
	        setTimeout(function() {
	            timer(remaining);
	        }, 1000);
	        return;
	    }
	
	    if(!timerOn) {
	        // Do validate stuff here
	        return;
	    }
	    
	    // Do timeout stuff here
	    alert('Timeout for otp');
	    }
	
	    timer(60);
	</script>
</body>
</html>