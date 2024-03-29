package mx.edu.ipicyt.imssipicytsd.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(mx.edu.ipicyt.imssipicytsd.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Ticket.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Transaction.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.SubtypeTransaction.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.ProductCat.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.RequestType.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.ContactType.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Impact.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Urgency.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.Priority.class.getName(), jcacheConfiguration);
            cm.createCache(mx.edu.ipicyt.imssipicytsd.domain.FilesNotes.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
