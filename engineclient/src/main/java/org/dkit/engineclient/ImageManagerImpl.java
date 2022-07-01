package org.dkit.engineclient;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import org.dkit.domain.valueobject.ImageName;
import org.dkit.engineclient.mapper.ImageMapper;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ImageManagerImpl implements ImageManager {

    private final DockerClient dockerClient;
    private final ImageMapper imageMapper;

    @Override
    public String createImage(String name, InputStream dockerFile) {
        var response = this.dockerClient.createImageCmd(name, dockerFile).exec();
        return response.getId();
    }


    public void pullImage(ImageName imageName) {
        this.dockerClient.pullImageCmd(imageName.toString());
    }

    public List<org.dkit.domain.Image> getImages() {
        return this.dockerClient.listImagesCmd().exec()
                .stream()
                .map(this.imageMapper::mapFromEngineType)
                .collect(Collectors.toList());
    }

    public Optional<org.dkit.domain.Image> getImageById(final String imageId) {
        return this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst()
                .map(this.imageMapper::mapFromEngineType);
    }

    public List<org.dkit.domain.Image> getImageByName(final String imageName) {
        return this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec()
                .parallelStream()
                .map(this.imageMapper::mapFromEngineType)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteImage(String imageId) {
        this.dockerClient.removeImageCmd(imageId).exec();
    }
}
