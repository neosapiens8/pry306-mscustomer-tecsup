package com.codigotecsup.mscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MscustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscustomerApplication.class, args);
	}

}
