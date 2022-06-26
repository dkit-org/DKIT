package org.dkit.fxclient.dto.mapper;

import org.dkit.domain.Image;
import org.dkit.fxclient.dto.ImageDTO;
import org.springframework.stereotype.Component;

@Component
public class ImageDTOMapper extends AbstractMapper<Image, ImageDTO> {
    @Override
    public ImageDTO mapToDTO(final Image image) {
        return new ImageDTO();
    }

    @Override
    public Image mapFromDTO(final ImageDTO imageDTO) {
        return new Image("someID", null, null );
    }
}
