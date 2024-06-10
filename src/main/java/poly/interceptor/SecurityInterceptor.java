package poly.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Kiem tra dang nhap");
		HttpSession session = request.getSession();
		if(session.getAttribute("trangchu") == null ||
			   session.getAttribute("sach") == null || session.getAttribute("nguoidung") == null ||
			   session.getAttribute("docgia") == null || session.getAttribute("phieumuontra") == null ||
			   session.getAttribute("phieuthu") == null || session.getAttribute("quydinh") == null ||
			   session.getAttribute("user") == null) {
			System.out.println("Chua dang nhap");
			response.sendRedirect(request.getContextPath() + "/login.htm");
			return false;
		} 
		System.out.println("Da dang nhap");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoggerInterceptor.postHandle()");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoggerInterceptor.afterCompletion()");
	}
}
