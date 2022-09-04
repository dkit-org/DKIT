package org.dkit.engineclient.container;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import org.dkit.contract.engineclient.ContainerManager;
import org.dkit.entity.Container;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContainerManagerImpl implements ContainerManager {

    private final DockerClient dockerClient;
    private final ContainerLogCallback containerLogCallback;
    private final ContainerMapper containerMapper;

    @Override
    public List<Container> listContainers() {
        return this.containerMapper.mapFromEngineTypeList(this.dockerClient.listContainersCmd().exec());
    }

    @Override
    public String createContainer(org.dkit.entity.valueobject.ImageName imageName){
        return this.dockerClient.createContainerCmd(imageName.toString())
                .exec()
                .getId();
    }

    @Override
    public String createContainer(org.dkit.entity.Image image){
        return this.dockerClient.createContainerCmd(image.getName().toString())
                .exec().getId();
    }

    @Override
    public void startContainer(String containerId){
        this.dockerClient.startContainerCmd(containerId).exec();
    }

    @Override
    public void stopContainer(String containerId){
        this.dockerClient.stopContainerCmd(containerId).exec();
    }

    @Override
    public void restartContainer(String containerId){
        this.dockerClient.restartContainerCmd(containerId).exec();
    }

    @Override
    public void removeContainer(String containerId){
        this.dockerClient.removeContainerCmd(containerId).exec();
    }

    @Override
    public void showLogs(String containerId){
        this.dockerClient.logContainerCmd(containerId).exec(this.containerLogCallback);
    }
}
