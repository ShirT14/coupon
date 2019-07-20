package coupon.system.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coupons.sys.beans.Company;
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
	@Path("login")
	@POST
		public ClientFacade login(String email, String password,ClientType clientType) throws CouponsSystemException
		{this.companyFacade= (CompanyFacade) LoginManager.getInstance().logIn(email, password, clientType);
		return this.companyFacade;
		}
	@Path("get-company")
	@GET
	public Company getComany()throws CouponsSystemException
	{
		return this.companyFacade.getCompany();
	}
	@Path("get-coupons")
	@GET
	public List <Coupon> getCoupons() throws CouponsSystemException
	{
	 return this.companyFacade.getCompanyCoupons();
	}
	@Path("coupon-by-max-price")
	@GET
	public List<Coupon> getCouponsByMaxPrice(Double maxPrice) throws CouponsSystemException
	{
		
		return this.companyFacade.getCompanyCoupons(maxPrice);
	}
	@Path("get-coupon-by-category")
	@GET
	public List<Coupon> GetCouponsByCategory(int categoryId) throws CouponsSystemException
	{
	return	this.companyFacade.getCompanyCoupons(categoryId);
	}
	@Path("add-coupon")
	@POST
	public void addCoupon(Coupon coupon) throws CouponsSystemException
	{
		 this.companyFacade.addCoupon(coupon);
		 
	}
	@Path("update-coupon")
	@PUT
	public void updateCoupon(Coupon coupon) throws CouponsSystemException
	{
	 this.companyFacade.updateCoupon(coupon);
	}
	@Path("delete-coupon")
	@DELETE
	public void deleteCoupon(int couponId) throws CouponsSystemException
	{
		this.companyFacade.deleteCoupon(couponId);
	}
	
	

}
