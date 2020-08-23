package com.customer.customerdemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= SpringApplication.run(CustomerdemoApplication.class, args);
          ctx.close();
           }

}
