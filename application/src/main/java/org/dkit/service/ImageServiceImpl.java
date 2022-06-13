package org.dkit.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import org.dkit.contract.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final DockerClient dockerClient;

    public ImageServiceImpl(DockerClient dockerClient){
        this.dockerClient = dockerClient;
    }

    @Override
    public List<Image> getImages(){
        return new ArrayList<>(this.dockerClient.listImagesCmd().exec());
    }

    @Override
    public Optional<Image> getImageById(final String imageId) {
        return this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst();
    }

    @Override
    public List<Image> getImageByName(final String imageName){
        return this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec();
    }

}
