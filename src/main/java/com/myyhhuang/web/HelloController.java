package com.myyhhuang.web;

import com.myyhhuang.beanim.IMCounty;
import com.myyhhuang.transactional.IMServiceEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
///@ImportResource("classpath:applicationContext.xml")
@RestController
public class HelloController {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(HelloController.class, args);

        /*
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        for (String name : beanNames) {
            System.out.println(name);
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

        Properties properties = (Properties) context.getBean("dataSourceProperties");
        System.out.println(properties);
         */
    }

/*
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    */
    //private final Logger logger = Logger.getLogger(String.valueOf(HelloController.class));
    private static Logger logger = LogManager.getLogger(HelloController.class.getName());
    static {
        ThreadContext.put("className", HelloController.class.getName());
    }

    //@Autowired
    //IMServiceDao IMServiceDao;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public IMCountyList index() throws Exception {
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        /*String sPassword = "";
        try {
            DesUtil des = new DesUtil();
            sPassword = des.decrypt("99d48e6365c86d26d21ea0f0ac1458ef");
            logger.info("sPassword: " + sPassword);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("EncryptedDataSource decrypt db login password exception"+e);
        }*/

/*暫時mark
        IMServiceEntry imServiceEntry = new IMServiceEntry();
        List<IMCounty> imCountyList = imServiceEntry.retriveIMCounty();
        if (imCountyList == null) {
            logger.info("retriveIMCounty fail.");
        } else {
            for (IMCounty imCounty : imCountyList) {
                logger.info(imCounty.toString());
            }
            return imCountyList;
        }

        return null;
 */
        IMCountyList imCountyList = new IMCountyList();
        IMCounty imCounty1 = new IMCounty("A12345", "測試1", new Date(), "J1234567");
        imCountyList.getImCounties().add(imCounty1);
        IMCounty imCounty2 = new IMCounty("B12345", "測試2", new Date(), "J1234567");
        imCountyList.getImCounties().add(imCounty2);

        return imCountyList;
    }

}
