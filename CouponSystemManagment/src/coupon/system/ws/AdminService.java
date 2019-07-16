package coupon.system.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.coupons.sys.beans.Company;
import com.coupons.sys.beans.Customer;
import com.coupons.sys.clients.AdminFacade;
import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

@Path("Admin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminService {
private AdminFacade adminFacade=new AdminFacade();
@Path("login")
@POST
	public ClientFacade login(String email, String password,ClientType clientType) throws CouponsSystemException
	{this.adminFacade= (AdminFacade) LoginManager.getInstance().logIn(email, password, clientType);
	return this.adminFacade;
	}
@Path("add-company")
@POST
public void addCompany(Company company) throws CouponsSystemException
{
	this.adminFacade.addCompany(company);
	}
@Path("delete-company")
@POST
public void deleteCompany(int companyId) throws CouponsSystemException
{
	this.adminFacade.deleteCompany(companyId);
	}
	@Path("add-customer")
	@POST
public void addCustomer(Customer customer) throws CouponsSystemException
{
		this.adminFacade.addCustomer(customer);
	}
	@Path("delete-customer")
	@POST
	public void deleteCustomer(int customerId) throws CouponsSystemException
	{
		this.adminFacade.deleteCustomer(customerId);
	}
	@Path("get-all-companies")
	@GET
	public List<Company> getAllCompanies() throws CouponsSystemException
	{
		return this.adminFacade.getAllCompanies();
	}
	@Path("get-all-customers")
	@GET
	public List<Customer> getAllCustomer() throws CouponsSystemException
	{
		return this.adminFacade.getAllCustomers();
	}
	@Path("get-customer")
	@GET
	public Customer getCustomer(int customerId) throws CouponsSystemException
	{
		return this.adminFacade.getOneCustomer(customerId);
	}
	
	@Path("get-company")
	@GET
	public Company getCompany(int companyId) throws CouponsSystemException
	{
		return this.adminFacade.getComapny(companyId);
	}
	@Path("update-company")
	@PUT
	public void updateCompany(Company company) throws CouponsSystemException
	{
		this.adminFacade.updateCompany(company);
	}
	@Path("update-customer")
	@PUT
	public void updateCustomer(Customer customer) throws CouponsSystemException
	{
		this.adminFacade.updateCustomer(customer);
		
	}
	
}
