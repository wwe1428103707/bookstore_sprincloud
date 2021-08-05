package com.yfj.bookstore.springcloud.provider.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.yfj.bookstore.springcloud.provider.account"},exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCaching
public class BookstoreSpringcloudProviderAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreSpringcloudProviderAccountApplication.class, args);
    }

}
