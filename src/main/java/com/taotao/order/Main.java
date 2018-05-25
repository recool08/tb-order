package com.taotao.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

@ComponentScans({@ComponentScan("com.taotao.order.service"), @ComponentScan("com.taotao.order.dao")})
@MapperScan("com.taotao.mapper")
@DubboComponentScan(basePackages = "com.taotao.order.service.impl")
@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}	
}
