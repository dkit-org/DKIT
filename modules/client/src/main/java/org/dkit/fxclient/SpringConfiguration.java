package org.dkit.fxclient;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;

@Configuration
@ComponentScan({
        // application
        "org.dkit.service",

        // engine
        "org.dkit.engineclient.image",
        "org.dkit.engineclient.container",

        // fx client
        "org.dkit.fxclient.core",
        "org.dkit.fxclient.controller",
        "org.dkit.fxclient.eventlistener",
        "org.dkit.fxclient.dto.mapper"
})
@PropertySource("classpath:application.properties")
public class SpringConfiguration {
    // TODO : register docker-java-client beans in engineClient project
    // TODO: to separate responsibilities
    @Bean
    public DockerClientConfig dockerClientConfig(){
        return DefaultDockerClientConfig.createDefaultConfigBuilder().build();
    }

    @Bean
    public ApacheDockerHttpClient apacheDockerHttpClient(DockerClientConfig config){
        return new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(60))
                .responseTimeout(Duration.ofSeconds(60))
                .build();
    }

    @Bean
    public DockerClient dockerClient(DockerClientConfig config, ApacheDockerHttpClient httpClient){
        return DockerClientImpl.getInstance(config, httpClient);
    }
}
