package org.dkit.contract.engineclient;

import org.dkit.entity.Container;

import java.util.List;

public interface ContainerManager {

    List<Container> listContainers();

    String createContainer(org.dkit.entity.valueobject.ImageName imageName);

    String createContainer(org.dkit.entity.Image image);

    void startContainer(String containerId);

    void stopContainer(String containerId);

    void restartContainer(String containerId);

    void removeContainer(String containerId);

    void showLogs(String containerId);
}
