package com.saidbouig.serviceregistrationdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrationDiscoveryApplication.class, args);
	}

}
