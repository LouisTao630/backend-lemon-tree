package app.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;

@Configuration
@EnableCaching
public class CachingConfig {

	@Primary
	@Bean
	public CacheManager cacheManager(JCacheCacheManager jcm, RedisCacheManager rdm) {
		CompositeCacheManager manager = new CompositeCacheManager();
		List<CacheManager> managers = new ArrayList<CacheManager>();
		managers.add(jcm);
		managers.add(rdm);
		manager.setCacheManagers(managers);
		return manager;
	}
}
