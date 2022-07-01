package org.dkit.engineclient.mapper;


import com.github.dockerjava.api.model.Container;

public class ContainerMapper extends AbstractMapper<org.dkit.domain.Container, Container> {
    @Override
    public Container mapToEngineType(org.dkit.domain.Container container) {
        return null;
    }

    @Override
    public org.dkit.domain.Container mapFromEngineType(Container typeDTO) {
        return null;
    }
}
