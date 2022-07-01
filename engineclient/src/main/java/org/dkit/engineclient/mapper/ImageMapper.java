package org.dkit.engineclient.mapper;

import com.github.dockerjava.api.model.Image;

public class ImageMapper extends AbstractMapper<org.dkit.domain.Image, Image> {
    @Override
    public Image mapToEngineType(org.dkit.domain.Image image) {
        return null;
    }

    @Override
    public org.dkit.domain.Image mapFromEngineType(Image typeDTO) {
        return null;
    }
}
