package app.cfg;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@PropertySource("classpath:/db_cfg/redis.properties")
public class RedisConfig {
		
	@Bean
	public JedisConnectionFactory jedisCf(@Value("${redis.hostname}")String hostName,@Value("${redis.port}") int port){
		JedisConnectionFactory cf = new JedisConnectionFactory();
		cf.setHostName(hostName);
		cf.setPort(port);
		return cf;
	}
	
	@Bean
	public RedisTemplate<Serializable, Serializable> redisTemplate(JedisConnectionFactory jedisCf){
		RedisTemplate<Serializable,Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
		redisTemplate.setConnectionFactory(jedisCf);
		return redisTemplate;
	}
		
}
