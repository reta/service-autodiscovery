package com.example.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.config.RestServiceDetails;
import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.retry.ExponentialBackoffRetry;
import com.netflix.curator.x.discovery.ServiceDiscovery;
import com.netflix.curator.x.discovery.ServiceDiscoveryBuilder;
import com.netflix.curator.x.discovery.details.JsonInstanceSerializer;

@Configuration
public class ClientConfig {	
	private static final String ZK_HOST = "localhost";

	@Bean( initMethod = "start", destroyMethod = "close" )
	public CuratorFramework curator() {
		 return CuratorFrameworkFactory.newClient( ZK_HOST, new ExponentialBackoffRetry( 1000, 3 ) );
	}
	
	@Bean( initMethod = "start", destroyMethod = "close" )
	public ServiceDiscovery< RestServiceDetails > discovery() {
		JsonInstanceSerializer< RestServiceDetails > serializer = 
        	new JsonInstanceSerializer< RestServiceDetails >( RestServiceDetails.class );

        return ServiceDiscoveryBuilder.builder( RestServiceDetails.class )
            .client( curator() )
            .basePath( "services" )
            .serializer( serializer )
            .build();        
	}
}
