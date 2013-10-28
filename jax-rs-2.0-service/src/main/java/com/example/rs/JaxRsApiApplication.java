package com.example.rs;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.core.env.Environment;

import com.example.config.AppConfig;
import com.netflix.curator.x.discovery.UriSpec;

@ApplicationPath( JaxRsApiApplication.APPLICATION_PATH )
public class JaxRsApiApplication extends Application {
	public static final String APPLICATION_PATH = "api";
	
	@Inject Environment environment;

	public UriSpec getUriSpec( final String servicePath ) {
		return new UriSpec( 
			String.format( "{scheme}://%s:{port}/%s/%s%s",
				environment.getProperty( AppConfig.SERVER_HOST ),
				AppConfig.CONTEXT_PATH,
				APPLICATION_PATH, 
				servicePath
			) );			
	}
}
