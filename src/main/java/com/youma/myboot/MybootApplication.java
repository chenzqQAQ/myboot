package com.youma.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.youma.action", "com.youma.service"})
@MapperScan("com.youma.dao")
@EnableTransactionManagement
public class MybootApplication{

    public static void main(String[] args) {
        SpringApplication.run(MybootApplication.class, args);
    }

}
