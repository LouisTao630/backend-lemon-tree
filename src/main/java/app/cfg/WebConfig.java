package app.cfg;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("app.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer cfg = new FreeMarkerConfigurer();
		cfg.setTemplateLoaderPath("/views/html/");
		return cfg;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	@Bean
	public ViewResolver resourceResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setViewClass(FreeMarkerView.class);
		resolver.setCache(true);
		resolver.setOrder(0);
		resolver.setContentType("text/html;charset=UTF-8");
		// resolver.setPrefix("/WEB-INF/views/html/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieMaxAge(300);
		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		resolver.setCookieName("lang");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
		super.addInterceptors(registry);
	}

}
