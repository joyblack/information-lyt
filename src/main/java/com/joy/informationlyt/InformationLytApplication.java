package com.joy.informationlyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.joy.informationlyt.domain.mapper")
public class InformationLytApplication {

    public static void main(String[] args) {
        SpringApplication.run(InformationLytApplication.class, args);
    }

}
