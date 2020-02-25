package com.myyhhuang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class HelloController {
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

/*
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    */
    private final Logger logger = Logger.getLogger(String.valueOf(HelloController.class));

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        /*
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host: " + instance.getHost() + ", service_id: " + instance.getServiceId());
        */
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        return "Hello World!";
    }

}
