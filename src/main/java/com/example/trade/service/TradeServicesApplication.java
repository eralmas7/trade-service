package com.example.trade.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient 
public class TradeServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServicesApplication.class, args);
    }

    @Bean
	public IndexTradeInfoService getIndexTradeInfoServiceService() {
    	return new DefaultIndexTradeInfoService();
	}
    
    @Bean
    public AlwaysSampler defaultSampler() {
      return new AlwaysSampler();
    }
}
