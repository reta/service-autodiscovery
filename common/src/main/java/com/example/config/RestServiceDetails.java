package com.example.config;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName( "serviceDetails" )
public class RestServiceDetails {
	private String version;
	
    public RestServiceDetails() {
    }
    
    public RestServiceDetails( final String version ) {
    	this.version = version;
    }
    
    public void setVersion( final String version ) {
		this.version = version;
	}
    
    public String getVersion() {
		return version;
	}    
}