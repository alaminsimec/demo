package com.alamin.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {
    @Value("${app.title}")
    private String appTitle;
    @Value("${app.description}")
    private String description;

    public void print() {
        System.out.println("Application Title: " + appTitle);
        System.out.println("Application description: " + description);
    }
}
