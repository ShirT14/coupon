package coupon.system.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coupons.sys.beans.Coupon;
import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.CompanyFacade;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

@Path("company")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
	private CompanyFacade companyFacade;
//
//	@Path("login")
//	@POST
//	public ClientFacade login(String email, String password, ClientType clientType) throws CouponsSystemException {
//		this.companyFacade = (CompanyFacade) LoginManager.getInstance().logIn(email, password, clientType);
//		return this.companyFacade;
//	}

	@Path("get-company")
	@GET
	public Response getComany() {
		try {
			return Response.status(Response.Status.OK).entity(this.companyFacade.getCompany()).build();

		} catch (Exception e) {

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("get-coupons")
	@GET
	public Response getCoupons() {
		try {
			return Response.status(Response.Status.OK).entity(this.companyFacade.getCompanyCoupons()).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();

			return Response.status(Response.Status.OK).entity(e.getMessage()).build();
		}
	}

	@Path("coupon-by-max-price")
	@GET
	public Response getCouponsByMaxPrice(@QueryParam ("maxPrice") Double maxPrice) {

		try {
			return Response.status(Response.Status.OK).entity(this.companyFacade.getCompanyCoupons(maxPrice)).build();
		} catch (CouponsSystemException e) {

			return Response.status(Response.Status.OK).entity(e.getMessage()).build();
		}
	}

	@Path("get-coupon-by-category")
	@GET
	public Response GetCouponsByCategory( @ QueryParam("categoryId") int categoryId) {
		try {
			return Response.status(Response.Status.OK).entity(this.companyFacade.getCompanyCoupons(categoryId)).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.OK).entity(e.getMessage()).build();
		}
	}

	@Path("add-coupon")
	@POST
	public Response addCoupon(Coupon coupon) {
		try {
			this.companyFacade.addCoupon(coupon);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Path("update-coupon")
	@PUT
	public Response updateCoupon( Coupon coupon) {
		try {
			this.companyFacade.updateCoupon(coupon);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}
	}

	@Path("delete-coupon")
	@DELETE
	public Response deleteCoupon( @QueryParam("couponId") int couponId) {
		try {
			this.companyFacade.deleteCoupon(couponId);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}