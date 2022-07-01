package org.dkit.internal.service;

import lombok.RequiredArgsConstructor;
import org.dkit.api.ImageService;
import org.dkit.domain.Image;
import org.dkit.engineclient.ImageManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageManager imageManager;

    @Override
    public Optional<Image> createImage(Image image) {
        return this.imageManager.createImage(image);
    }

    @Override
    public List<Image> getImages() {
        return null;
    }

    @Override
    public Optional<Image> getImageById(String imageId) {
        return Optional.empty();
    }

    @Override
    public List<Image> getImageByName(String imageName) {
        return null;
    }
}
