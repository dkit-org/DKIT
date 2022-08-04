package org.dkit.engineclient.image;

import com.github.dockerjava.api.model.Image;
import lombok.extern.log4j.Log4j2;
import org.dkit.engineclient.common.AbstractMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Log4j2
public class ImageMapper extends AbstractMapper<org.dkit.entity.Image, Image> {
    @Override
    public Image mapToEngineType(org.dkit.entity.Image image) {
        return null;
    }

    @Override
    public org.dkit.entity.Image mapFromEngineType(Image typeDTO) {
        log.info( "Image containers {}", typeDTO.getContainers());
        var imageName = new org.dkit.entity.valueobject.ImageName("somenam", typeDTO.getRepoTags()[0]);
        return new org.dkit.entity.Image(
                typeDTO.getId(),
                imageName,
                new ArrayList<>());
    }
}
