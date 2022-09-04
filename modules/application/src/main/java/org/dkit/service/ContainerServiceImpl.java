package org.dkit.service;

import lombok.RequiredArgsConstructor;
import org.dkit.api.ContainerService;
import org.dkit.contract.engineclient.ContainerManager;
import org.dkit.entity.Container;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {

    private final ContainerManager containerManager;

    public List<Container> getContainers(){
        return this.containerManager.listContainers();
    }

    public Optional<Container> createContainer(Container container) {
        return Optional.empty();
    }

    public Optional<Container> createContainer(
            final String name,
            final String imageName,
            final String imageTag) {
        return Optional.empty();
    }

    public void startContainer(final String id) {
    }

    public void stopContainer(final String id) {

    }

    public Optional<String> getLogs(final String id){
        return Optional.empty();
    }

}

