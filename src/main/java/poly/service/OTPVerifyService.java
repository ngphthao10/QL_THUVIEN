package poly.service;

import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OTPVerifyService {
	
	@Autowired
    private JavaMailSender mailSender;

    private static final String CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6;

    public String generateOTP() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);

        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return otp.toString();
    }

    public int sendOTPEmail(String toEmail, String otp) {
        try {
        	MimeMessage mail = mailSender.createMimeMessage();
        	MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom("n21dccn078@student.ptithcm.edu.vn");
			helper.setTo(toEmail);
			helper.setSubject("Xác nhận OTP");
			helper.setText("Mã xác nhận OTP của bạn: " + otp);
			
			mailSender.send(mail);
			return 1;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

    }
	
}
