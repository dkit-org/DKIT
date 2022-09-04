package org.dkit.engineclient.image;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import org.dkit.contract.engineclient.ImageManager;
import org.dkit.entity.valueobject.ImageName;
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
    public Optional<String> createImage(String name, InputStream dockerFile) {
        var response = this.dockerClient.createImageCmd(name, dockerFile).exec();
        return Optional.of(response.getId());
    }


    public void pullImage(ImageName imageName) {
        this.dockerClient.pullImageCmd(imageName.toString());
    }

    public List<org.dkit.entity.Image> getImages() {
        return this.dockerClient.listImagesCmd().exec()
                .stream()
                .map(this.imageMapper::mapFromEngineType)
                .collect(Collectors.toList());
    }

    public Optional<org.dkit.entity.Image> getImageById(final String imageId) {
        return this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst()
                .map(this.imageMapper::mapFromEngineType);
    }

    public List<org.dkit.entity.Image> getImageByName(final String imageName) {
        return this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec()
                .parallelStream()
                .map(this.imageMapper::mapFromEngineType)
                .collect(Collectors.toList());
    }

    @Override
    public void removeImage(String imageId) {
        this.dockerClient.removeImageCmd(imageId).exec();
    }
}
