package com.ssafy.homework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan(basePackages = "com.ssafy.homework.model.repository")
public class WebConfiguration implements WebMvcConfigurer{

	
}
