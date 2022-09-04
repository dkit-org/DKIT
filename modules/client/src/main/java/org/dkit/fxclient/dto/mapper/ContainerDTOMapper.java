package org.dkit.fxclient.dto.mapper;

import org.dkit.entity.Container;
import org.dkit.fxclient.dto.ContainerDTO;
import org.springframework.stereotype.Component;

@Component
public class ContainerDTOMapper extends AbstractMapper<Container, ContainerDTO> {
    @Override
    public ContainerDTO mapToDTO(final Container container) {
        return new ContainerDTO(container.getId(), container.getName());
    }

    @Override
    public Container mapFromDTO(final ContainerDTO containerDTO) {
        return null;
    }
}
