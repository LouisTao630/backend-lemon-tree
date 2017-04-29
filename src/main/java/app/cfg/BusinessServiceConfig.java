package app.cfg;

import org.springframework.context.annotation.Configuration;

import app.service.RegistCustomerService;
import app.service.impl.RegistCustomerServiceImpl;

@Configuration
public class BusinessServiceConfig {

	public RegistCustomerService registCustomerService() {
		RegistCustomerService service = new RegistCustomerServiceImpl();
		return service;
	}

}
