package app.cfg;

import java.net.URISyntaxException;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JCacheConfig {

	@Bean
	public CacheManager ehcache() throws URISyntaxException {
		CachingProvider provider = Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider");
		CacheManager cacheManager = provider.getCacheManager(getClass().getResource("/db_cfg/ehcache.xml").toURI(), getClass().getClassLoader());
		return cacheManager;
	}

	@Bean("JCacheCacheManager")
	public JCacheCacheManager ehcacheManager(CacheManager ehcache) {
		return new JCacheCacheManager(ehcache);
	}

}
