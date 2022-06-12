package org.dkit.contract.service;

import com.github.dockerjava.api.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    List<Image> getImages();

    Optional<Image> getImageById(String imageId);

    List<Image> getImageByName(String imageName);
}
