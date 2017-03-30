package app.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"app"},
excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class Root {

	@Profile("Product")
	@Bean
	public DataSource jndiDS(){
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/mysql");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFB.getObject();
		
	}
	
	@Profile("Dev")
	@Bean
	public DataSource mysqlDS(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("");
		ds.setUrl("jdbc:mysql:tcp://192.168.0.1:3306/web_app");
		ds.setUsername("root");
		ds.setPassword("MyNewPass4!");
		ds.setInitialSize(5);
		ds.setMaxIdle(5);
		return ds;
	}
	
	@Profile("Local")
	@Bean
	public DataSource embeddedDS(){
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.addScript("classpath:/sql/h2/schema.sql")
			.addScript("classpath:/sql/h2/test-data.sql")
			.build();
	}
	
}
