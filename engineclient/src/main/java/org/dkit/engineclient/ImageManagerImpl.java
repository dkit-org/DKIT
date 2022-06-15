package org.dkit.engineclient;

import com.github.dockerjava.api.DockerClient;
import lombok.RequiredArgsConstructor;
import org.dkit.domain.Image;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ImageManagerImpl implements ImageManager{

    private final DockerClient dockerClient;


    public Image createImage(org.dkit.domain.Image image) {
        return null;
    }

    public Collection<Image> getImages(){
        var images = this.dockerClient.listImagesCmd().exec();
        // TODO : conver docker-java images to domain.image
        return new ArrayList<>();
    }

    public Optional<Image> getImageById(final String imageId) {
        var images =  this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst();
        // TODO : conver docker-java images to domain.image
        return Optional.of(new Image("fake id", "fake name"));
    }

    public Collection<Image> getImageByName(final String imageName){
        var images =  this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec();
        // TODO : conver docker-java images to domain.image
        return new ArrayList<>();
    }
}
