package org.dkit.service;

import lombok.RequiredArgsConstructor;
import org.dkit.api.ImageService;
import org.dkit.domain.Image;
import org.dkit.contract.engineclient.ImageManager;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageManager imageManager;

    @Override
    public Optional<String> createImage(
            final String imageName,
            final InputStream dockerFile
            ) {
        return this.imageManager.createImage(imageName, dockerFile);
    }

    @Override
    public List<Image> getImages() {
        return this.imageManager.getImages();
    }

    @Override
    public Optional<Image> getImageById(String imageId) {
        return this.getImageById(imageId);
    }

    @Override
    public List<Image> getImageByName(String imageName) {
        return this.imageManager.getImageByName(imageName);
    }
}
