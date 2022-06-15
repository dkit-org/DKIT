package org.dkit.service;

import org.dkit.api.ImageService;
import org.dkit.domain.Image;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public Image createImage(Image image) {
        return null;
    }

    @Override
    public Collection<Image> getImages() {
        return null;
    }

    @Override
    public Optional<Image> getImageById(String imageId) {
        return Optional.empty();
    }

    @Override
    public Collection<Image> getImageByName(String imageName) {
        return null;
    }
}
