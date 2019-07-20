package coupon.system.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.coupons.sys.beans.Coupon;
import com.coupons.sys.beans.Customer;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.CustomerFacade;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {
	private CustomerFacade customerFacade;

	@Path("login")
	@POST
	public CustomerFacade login(String email, String password, ClientType clientType) throws CouponsSystemException {
		return customerFacade = (CustomerFacade) LoginManager.getInstance().logIn(email, password, clientType);

	}

	@Path("get-customer")
	@POST
	public Customer getCustomer() throws CouponsSystemException {
		return customerFacade.getCustomer();

	}

	@Path("get-all-coupons-by-max-price")
	@POST
	public List<Coupon> getAllCouponsByMaxPrice(Double maxPrice) throws CouponsSystemException {
		return customerFacade.getAllCoupon(maxPrice);

	}

	@Path("get-all-customer-coupons")
	@POST
	public List<Coupon> getAllCustomerCoupons() throws CouponsSystemException {
		return customerFacade.getAllCustomerCoupons();

	}

	@Path("get-all-coupons-by-max-price")
	@POST
	public void purchaseCoupon(Coupon coupon) throws CouponsSystemException {
		customerFacade.purchaseCoupon(coupon);
	}

}