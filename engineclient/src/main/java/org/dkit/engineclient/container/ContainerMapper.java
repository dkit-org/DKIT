package org.dkit.engineclient.container;


import com.github.dockerjava.api.model.Container;
import org.dkit.engineclient.common.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
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
