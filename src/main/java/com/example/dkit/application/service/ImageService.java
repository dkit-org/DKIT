package com.example.dkit.application.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final DockerClient dockerClient;

    public ImageService(DockerClient dockerClient){
        this.dockerClient = dockerClient;
    }

    public List<Image> getImages(){
        return new ArrayList<>(this.dockerClient.listImagesCmd().exec());
    }

    public Optional<Image> getImageById(final String imageId) {
        return this.dockerClient.listImagesCmd()
                .exec()
                .stream()
                .filter(el -> el.getId().equals(imageId))
                .findFirst();
    }

    public List<Image> getImageByName(final String imageName){
        return this.dockerClient.listImagesCmd()
                .withImageNameFilter(imageName)
                .exec();
    }
}
