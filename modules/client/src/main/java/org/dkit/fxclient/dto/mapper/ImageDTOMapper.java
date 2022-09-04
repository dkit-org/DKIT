package org.dkit.fxclient.dto.mapper;

import org.dkit.entity.Image;
import org.dkit.fxclient.dto.ImageDTO;
import org.springframework.stereotype.Component;

@Component
public class ImageDTOMapper extends AbstractMapper<Image, ImageDTO> {
    @Override
    public ImageDTO mapToDTO(final Image image) {
        return new ImageDTO(
                image.getId(),
                image.getName().getName(),
                image.getName().getTag());
    }

    @Override
    public Image mapFromDTO(final ImageDTO imageDTO) {
        return new Image("someID", null, null );
    }
}
