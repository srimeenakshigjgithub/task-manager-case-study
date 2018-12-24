package com.gjsm.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.gjsm.taskmanager.filter.TasksFilter;

@EnableAutoConfiguration
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