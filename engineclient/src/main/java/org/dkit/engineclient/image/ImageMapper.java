package org.dkit.engineclient.image;

import com.github.dockerjava.api.model.Image;
import lombok.extern.slf4j.Slf4j;
import org.dkit.engineclient.common.AbstractMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class ImageMapper extends AbstractMapper<org.dkit.domain.Image, Image> {
    @Override
    public Image mapToEngineType(org.dkit.domain.Image image) {
        return null;
    }

    @Override
    public org.dkit.domain.Image mapFromEngineType(Image typeDTO) {
        log.info( "Image containers {}", typeDTO.getContainers());
        var imageName = new org.dkit.domain.valueobject.ImageName("somenam", typeDTO.getRepoTags()[0]);
        return new org.dkit.domain.Image(
                typeDTO.getId(),
                imageName,
                new ArrayList<>());
    }
}
