package com.example.dkit.application.bean;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DockerBeans {

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
