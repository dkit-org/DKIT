package org.dkit.api;


import org.dkit.domain.Image;

import java.util.Collection;
import java.util.Optional;

// TODO: document class
public interface ImageService {
    Image createImage(Image image);

    Collection<Image> getImages();

    Optional<Image> getImageById(String imageId);

    Collection<Image> getImageByName(String imageName);
}
