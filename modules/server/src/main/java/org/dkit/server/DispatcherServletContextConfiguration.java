package org.dkit.server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableWebMvc
@ComponentScan(basePackages = {"org.dkit.server.controller"})
public class DispatcherServletContextConfiguration {
}
