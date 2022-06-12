package org.dkit.fxclient.service;

import org.dkit.fxclient.model.Container;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerService {

    public List<Container> getContainers() {
        return List.of(
                new Container(1, "first image name", "image id"),
                new Container(1, "second image name", "image id"),
                new Container(1, "third image name", "image id"));

    }
}
