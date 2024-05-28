package poly.recaptcha;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

public class VerifyUtils {
	
	public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
	
	public static boolean verify(String gRecaptchaResponse) {
		if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0 ) {
			return false;
		}
		
		try {
			URL verifyURL = new URL(SITE_VERIFY_URL);
			
			// Mở một kết nối (connection) tới URL trên
			HttpsURLConnection conn = (HttpsURLConnection)verifyURL.openConnection();
			
			// Thêm các thông tin Header và Request chuẩn bị gửi tới Server
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246");
			conn.setRequestProperty("Accept-Language", "vi-VN,vi;q=0.8");
			
			// Dữ liệu sẽ được gửi tới Server
			String postParams = "secret=" + Constraint.SECRET_KEY + "&response=" + gRecaptchaResponse;
			
			// Send Request
			conn.setDoOutput(true);
			
			// Lấy output stream (luồng đầu ra) của kết nối tới Server
			// Ghi dữ liệu vào output stream, có nghĩa là gửi thông tin tới server
			OutputStream outStream = conn.getOutputStream();
			outStream.write(postParams.getBytes());
			
			outStream.flush();
			outStream.close();
			
			// Mã trả lời được trả về từ Server 
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode = " + responseCode);
			
			
			// Lấy input Stream (luồng đầu vào) của connection để lấy dữ liệu gửi đến từ Server
			InputStream is = conn.getInputStream();
			
			JsonReader jsonReader = Json.createReader(is);
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();
			
			// ==> {success: true}
			System.out.println("Response: " + jsonObject);
			
			boolean success = jsonObject.getBoolean("success");
			return success;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
