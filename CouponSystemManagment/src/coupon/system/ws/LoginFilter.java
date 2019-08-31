package coupon.system.ws;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;


@WebFilter( urlPatterns   = { "/CouponSystemManagment/rest/sec/*" })

public class LoginFilter implements Filter{

	@Context HttpServletRequest req;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	String NextPage;
	 HttpServletRequest req=(HttpServletRequest) request;
	 HttpServletResponse resp=(HttpServletResponse) response;
	 
	 HttpSession session=req.getSession(false);
	 if(session==null)
	 {
		System.out.println("no session");
	 }
		
	 else {
		 
		
		 chain.doFilter(request, response);
		} 
	 }
	

	

}
