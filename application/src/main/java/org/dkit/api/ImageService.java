package org.dkit.api;


import org.dkit.domain.Image;

import java.util.List;
import java.util.Optional;

// TODO: document class
public interface ImageService {
    Optional<Image> createImage(Image image);

    List<Image> getImages();

    Optional<Image> getImageById(String imageId);

    List<Image> getImageByName(String imageName);
}
