package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Users;
//import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
@RequestMapping("/demo1")
public class Demo1_Conroller {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable("id") Long id) {
 		List<ServiceInstance> instances = discoveryClient.getInstances("DEMO-2");
        if (instances.isEmpty()) {
            throw new RuntimeException("No instances available for service: OTHER-SERVICE-NAME");
        }
         String url = instances.get(0).getUri().toString() + "/demo2/"+id;
        ResponseEntity<Users> response = restTemplate.getForEntity(url, Users.class);
        return response.getBody();
 		
        
 
	}
}
