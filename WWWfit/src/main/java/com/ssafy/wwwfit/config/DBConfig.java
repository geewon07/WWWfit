package com.ssafy.wwwfit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.wwwfit.model.dao")
public class DBConfig {

}
