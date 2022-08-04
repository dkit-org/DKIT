package org.dkit.engineclient.container;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import org.dkit.contract.engineclient.ContainerManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContainerManagerImpl implements ContainerManager {

    private final DockerClient dockerClient;
    private final ContainerLogCallback containerLogCallback;

    public String createContainer(org.dkit.entity.valueobject.ImageName imageName){
        return this.dockerClient.createContainerCmd(imageName.toString())
                .exec()
                .getId();
    }

    public String createContainer(org.dkit.entity.Image image){
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
        this.dockerClient.logContainerCmd(containerId).exec(this.containerLogCallback);
    }
}
