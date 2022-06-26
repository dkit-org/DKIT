package org.dkit.engineclient;

import org.dkit.domain.Image;

import java.util.List;
import java.util.Optional;

public interface ImageManager {
    Optional<Image> getImageById(String id);
    List<Image> getImages();
    List<Image> getImageByName(String name);

    Optional<Image> createImage(String name, String tag);

    //Optional<Image> createImage(String name, String tag, );

    void deleteImage(String id);
}
