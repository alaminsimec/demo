package com.alamin.demo.config;

import com.alamin.demo.utils.common.MessageFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppConfigEnvironmentReader {

    private final Environment environment;

    public void printAppConfig() {
        String title = environment.getProperty("app.title");
        String description = environment.getProperty("app.description");

        System.out.println("Application Title: " +  MessageFormatter.format(title, "Spring"));
        System.out.println("Application Description: " + description);
    }
}
