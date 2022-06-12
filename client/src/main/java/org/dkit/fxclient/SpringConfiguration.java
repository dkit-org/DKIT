package org.dkit.fxclient;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "org.dkit.fxclient.common",
        "org.dkit.fxclient.controller",
        "org.dkit.fxclient.eventlistener"
})
@PropertySource("classpath:application.properties")
public class SpringConfiguration {
}
