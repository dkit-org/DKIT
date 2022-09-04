package org.dkit.engineclient.container;


import com.github.dockerjava.api.model.Container;
import org.dkit.engineclient.common.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class ContainerMapper extends AbstractMapper<org.dkit.entity.Container, Container> {
    @Override
    public Container mapToEngineType(org.dkit.entity.Container container) {
        return null;
    }

    @Override
    public org.dkit.entity.Container mapFromEngineType(Container typeDTO) {
        return new org.dkit.entity.Container(typeDTO.getId());
    }
}
