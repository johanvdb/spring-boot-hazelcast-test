package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableCaching
public class SpringBootHazelcastTestApplication {

	private static final Log log = LogFactory.getLog(SpringBootHazelcastTestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHazelcastTestApplication.class, args);
	}
	
	@Autowired CacheManager cacheManager;
	
	@RequestMapping("/get")
	@Cacheable("get")
	public String getString() {
		log.info(cacheManager.getClass().getName());
		return "Hello World";
	}
}
