package coupon.system.ws;
import javax.ws.rs.core.Response;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.coupons.sys.beans.Coupon;
import com.coupons.sys.beans.Customer;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.CustomerFacade;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;


@Path("customer-sec")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {
	private CustomerFacade customerFacade;

//	@Path("login")
//	@POST
//	public CustomerFacade login(String email, String password, ClientType clientType) throws CouponsSystemException {
//		return customerFacade = (CustomerFacade) LoginManager.getInstance().logIn(email, password, clientType);
//
//	}

	@Path("get-customer")
	@GET
	public Response getCustomer()  {
		
		try {
			return Response.status(Response.Status.OK).entity(customerFacade.getCustomer()).build();
		} catch (CouponsSystemException e) {
			
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("get-all-coupons-by-max-price")
	@GET
	public Response getAllCouponsByMaxPrice(@QueryParam ("maxPrice") Double maxPrice)  {
		try {
			
			return  Response.status(Response.Status.OK).entity(customerFacade.getAllCoupon(maxPrice)).build();
		} catch (CouponsSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

	@Path("get-all-customer-coupons")
	@GET
	public Response getAllCustomerCoupons() {
		 try {
			
			return  Response.status(Response.Status.OK).entity((customerFacade.getAllCustomerCoupons())).build();
		} catch (CouponsSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

	@Path("purchase-coupon")
	@GET
	
	public Response purchaseCoupon( Coupon coupon) {
		
		try {
			customerFacade.purchaseCoupon(coupon);
			return  Response.status(Response.Status.OK).build();
			
		} catch (CouponsSystemException e) {
			
			e.printStackTrace();
			return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		
	}

}