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

import com.coupons.sys.clients.AdminFacade;
import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.CompanyFacade;
import com.coupons.sys.clients.CustomerFacade;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

@Path("login-service")
public class LoginService {

	@Context
	HttpServletRequest req;

	@PostConstruct
	public void getSession() {
		req.getSession(false);
	}

	@GET
	@Path("login")
	public Response login(@QueryParam("email") String email, @QueryParam("password") String password,
			@QueryParam("client-type") String clientType) {
		
		System.out.println(email+  password + clientType );

		try {
			ClientFacade client = null;
			switch (clientType) {
			case "company":

				client = (CompanyFacade) LoginManager.getInstance().logIn(email, password, ClientType.COMPANY);
				System.out.println("company case");
				break;

			case "customer":
				client = (CustomerFacade) LoginManager.getInstance().logIn(email, password, ClientType.CUSTOMER);
				System.out.println("customer case");
				break;
			case "admin":
				client = (AdminFacade) LoginManager.getInstance().logIn(email, password, ClientType.ADMINISTRATOR);
				System.out.println("admin case");
				break;


			}

			req.getSession(true).setAttribute("clientFacade", client);

			if (client == null) {

				System.out.println("client null");
			}
			
			return Response.status(Response.Status.OK).build();

		} catch (CouponsSystemException e) {

			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

}
