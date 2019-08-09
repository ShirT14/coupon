package coupon.system.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import com.coupons.sys.clients.ClientFacade;
import com.coupons.sys.clients.ClientType;
import com.coupons.sys.clients.LoginManager;
import com.coupons.sys.exeptions.CouponsSystemException;

public class LoginFilter implements ClientRequestFilter {

	@Override
	public void filter(ClientRequestContext req) throws IOException {
		try {
			ClientFacade clientfacade= LoginManager.getInstance().logIn((String)req.getProperty("email"),
					(String)req.getProperty( "password"),(ClientType) req.getProperty( "clientType"));
		} catch (CouponsSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		

	}

}
