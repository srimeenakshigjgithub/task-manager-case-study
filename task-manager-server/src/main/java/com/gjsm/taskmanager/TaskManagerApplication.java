package com.gjsm.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.gjsm.taskmanager.cors.TasksFilter;

@EnableWebSecurity
@SpringBootApplication
public class TaskManagerApplication extends SpringBootServletInitializer
{
     public static void main(String[] args) 
     {
         SpringApplication.run(TaskManagerApplication.class, args);
     }
     
    @Bean 
     public FilterRegistrationBean<TasksFilter> tasksFilter() { 
             FilterRegistrationBean<TasksFilter> registrationBean  = new FilterRegistrationBean<TasksFilter>();

             registrationBean.setFilter(new TasksFilter()); 
             registrationBean.addUrlPatterns("/*");

             return registrationBean; 
     }
}

