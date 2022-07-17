package org.dkit.contract.engineclient;

import org.dkit.domain.Image;
import org.dkit.domain.valueobject.ImageName;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface ImageManager {
    Optional<String> createImage(String name, InputStream dockerFile);
    void pullImage(ImageName imageName);
    Optional<Image> getImageById(String id);
    List<Image> getImages();
    List<Image> getImageByName(String name);

    void removeImage(String id);
}
