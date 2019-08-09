package coupon.system.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;





@Path("login-service")
public class LoginService {

	@Context HttpServletRequest req;
	
	@PostConstruct
	public void getSession()
	{
	  req.getSession(false);
	}
	@GET
	@Path("login")
	public Response login ( @QueryParam("email")String email,
			@QueryParam("password") String password, @QueryParam("client-type") String clientType )
	{
		ClientType currentClientType ;
	try {
		switch (clientType) {
		case "company":
			currentClientType=ClientType.COMPANY;
			break;
		case "admin":
			currentClientType=ClientType.ADMINISTRATOR;
			break;
		case "3":
			currentClientType=ClientType.CUSTOMER;
			break;
		default:
			currentClientType=null;
			break;
		}
		ClientFacade client=LoginManager.getInstance().logIn(email, password,currentClientType);
		req.getSession(true).setAttribute("clientFacade", client);
		return  Response.status(Response.Status.OK).build();
	} catch (CouponsSystemException e) {
		
		e.printStackTrace();
		return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
	}
		
	}
	
	
	

}
