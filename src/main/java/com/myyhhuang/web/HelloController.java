package com.myyhhuang.web;

import com.myyhhuang.beanim.IMCounty;
import com.myyhhuang.test.User;
import com.myyhhuang.transactional.IMServiceEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
///@ImportResource("classpath:applicationContext.xml")
@RestController
public class HelloController {
    public static void main(String[] args) {
        System.setProperty("className", "xxx");
        ApplicationContext applicationContext = SpringApplication.run(HelloController.class, args);
    }

    private static Logger logger = LogManager.getLogger(HelloController.class.getName());
    static {
        ThreadContext.put("className", HelloController.class.getName());
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public IMCountyList index() throws Exception {
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        IMServiceEntry imServiceEntry = new IMServiceEntry();
        IMCountyList imCountyList = new IMCountyList();
        List<IMCounty> imCountyListTmp = imServiceEntry.retriveIMCounty();
        if (imCountyListTmp == null) {
            logger.info("retriveIMCounty fail.");
        } else {
            for (IMCounty imCounty : imCountyListTmp) {
                logger.info(imCounty.toString());
            }
        }
        imCountyList.setImCounties(imCountyListTmp);

        /*
        IMCountyList imCountyList = new IMCountyList();
        IMCounty imCounty1 = new IMCounty("A12345", "測試1", new Date(), "J1234567");
        imCountyList.getImCounties().add(imCounty1);
        IMCounty imCounty2 = new IMCounty("B12345", "測試2", new Date(), "J1234567");
        imCountyList.getImCounties().add(imCounty2);
        */
        /*
        String sPassword = "";
        try {
            DesUtil des = new DesUtil();
            sPassword = des.decrypt("99d48e6365c86d26d21ea0f0ac1458ef");
            logger.info("sPassword: " + sPassword);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("EncryptedDataSource decrypt db login password exception"+e);
        }*/

        return imCountyList;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
