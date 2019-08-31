package coupon.system.ws;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.coupons.sys.beans.Company;
import com.coupons.sys.beans.Customer;
import com.coupons.sys.clients.AdminFacade;
import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.CustomerFacade;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

@Path("sec/Admin-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminService {
	@Context
	HttpServletRequest req;
	private AdminFacade adminFacade = (AdminFacade) req.getSession().getAttribute("clientFacade");

	@Path("add-company")
	@POST
	public Response addCompany(Company company) {
		try {
			this.adminFacade.addCompany(company);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("delete-company")
	@DELETE
	public Response deleteCompany(@QueryParam("companyId") int companyId) {
		try {
			this.adminFacade.deleteCompany(companyId);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {

			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("add-customer")
	@POST
	public Response addCustomer(Customer customer) {
		try {
			this.adminFacade.addCustomer(customer);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("delete-customer")
	@DELETE
	public Response deleteCustomer(@QueryParam("customerId") int customerId) {
		try {
			this.adminFacade.deleteCustomer(customerId);
			return Response.status(Response.Status.OK).build();

		} catch (CouponsSystemException e) {

			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

	@Path("get-all-companies")
	@GET
	public Response getAllCompanies() {
		try {
			this.adminFacade.getAllCompanies();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(this.adminFacade.getAllCompanies())
					.build();
		} catch (CouponsSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("get-all-customers")
	@GET
	public Response getAllCustomer() {
		try {

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(this.adminFacade.getAllCustomers())
					.build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();

		}
	}

	@Path("get-customer")
	@GET
	public Response getCustomer(@QueryParam("customerId") int customerId) {
		try {
			this.adminFacade.getOneCustomer(customerId);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(this.adminFacade.getAllCustomers())
					.build();
		} catch (CouponsSystemException e) {

			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Path("get-company")
	@GET
	public Response getCompany(@QueryParam("companyId") int companyId) {
		try {
			;
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(this.adminFacade.getComapny(companyId))
					.build();
		} catch (CouponsSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

	@Path("update-company")
	@PUT
	public Response updateCompany(Company company) {
		try {
			this.adminFacade.updateCompany(company);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

	@Path("update-customer")
	@PUT
	public Response updateCustomer(Customer customer) {
		try {
			this.adminFacade.updateCustomer(customer);
			return Response.status(Response.Status.OK).build();
		} catch (CouponsSystemException e) {

			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

	}

}
