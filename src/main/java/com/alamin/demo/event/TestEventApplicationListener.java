package com.alamin.demo.event;

import com.alamin.demo.config.AppConfigEnvironmentReader;
import com.alamin.demo.config.AppProperties;
import com.alamin.demo.config.MyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestEventApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private final AppConfigEnvironmentReader appConfigEnvironmentReader;
    private final AppProperties appProperties;
    private final MyProperties myProperties;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        appConfigEnvironmentReader.printAppConfig();
        System.out.println(appProperties.getTitle()+"\n"+appProperties.getDescription());
        myProperties.print();

    }
}
