package org.dkit.service;

import lombok.Setter;
import org.dkit.api.ContainerService;
import org.dkit.domain.Container;
import org.dkit.domain.valueobject.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerServiceImpl implements ContainerService {

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

