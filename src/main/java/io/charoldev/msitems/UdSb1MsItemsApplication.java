package io.charoldev.msitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UdSb1MsItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdSb1MsItemsApplication.class, args);
    }

}
