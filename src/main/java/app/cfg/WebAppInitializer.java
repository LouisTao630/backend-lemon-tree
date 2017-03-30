package app.cfg;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { Root.class, RedisConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {

		ServletContextRequestLoggingFilter loggingFilter = createServletLoggingFilter();
		return new Filter[] { loggingFilter };
	}

	/**
	 * Create a Servlet logging filter, this filter will log all HTTP request
	 * 
	 * @return
	 */
	@Bean
	public ServletContextRequestLoggingFilter createServletLoggingFilter() {
		ServletContextRequestLoggingFilter loggingFilter = new ServletContextRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		return loggingFilter;
	}

}
