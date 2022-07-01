package org.dkit.engineclient;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Frame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContainerManagerImpl implements ContainerManager {

    private final DockerClient dockerClient;

    public String createContainer(org.dkit.domain.valueobject.ImageName imageName){
        return this.dockerClient.createContainerCmd(imageName.toString())
                .exec()
                .getId();
    }

    public String createContainer(org.dkit.domain.Image image){
        return this.dockerClient.createContainerCmd(image.getName().toString())
                .exec().getId();
    }

    public void startContainer(String containerId){
        this.dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId){
        this.dockerClient.stopContainerCmd(containerId).exec();
    }

    public void restartContainer(String containerId){
        this.dockerClient.restartContainerCmd(containerId).exec();
    }

    public void removeContainer(String containerId){
        this.dockerClient.removeContainerCmd(containerId).exec();
    }

    public void showLogs(String containerId){
        this.dockerClient.logContainerCmd(containerId).exec().onNext(Frame);
    }

}
