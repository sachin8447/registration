package com.techphantoms.registration.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Component
public class WebAppMain extends WebMvcConfigurerAdapter {
    /*public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebAppMain.class);
        System.out.print("Starting app with System Args: [" );
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println("]");
        app.run(args);
    }*/


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
