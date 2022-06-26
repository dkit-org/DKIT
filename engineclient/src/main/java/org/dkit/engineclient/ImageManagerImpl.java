package org.dkit.engineclient;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public abstract class ImageManagerImpl{

    private final DockerClient dockerClient;

    public Optional<String> createImage(String name, InputStream dockerFile) {
        var response = this.dockerClient.createImageCmd(name, dockerFile).exec();
        return Optional.of(response.getId());
    }

    public void downloadImage(String imageNameAndId){
        this.dockerClient.pullImageCmd(imageNameAndId);
    }

    public List<org.dkit.domain.Image> getImages(){
        var images = this.dockerClient.listImagesCmd().exec();
        return new ArrayList<>();
    }

    public Optional<Image> getImageById(final String imageId) {
        var images =  this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst();
        // TODO : conver docker-java images to domain.image
        return Optional.empty();
    }

    public List<Image> getImageByName(final String imageName){
        var images =  this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec();
        // TODO : conver docker-java images to domain.image
        return new ArrayList<>();
    }
}
