package com.example.dkit.api.controller;

import com.example.dkit.application.service.ImageService;
import com.github.dockerjava.api.model.Image;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {


    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("/")
    public List<Image> getImages(){
        return  this.imageService.getImages();
    }

    @GetMapping("/{imageId}")
    public Optional<Image> getImageById(@PathVariable String imageId){
        return this.imageService.getImageById(imageId);
    }

    @GetMapping("/filter")
    public List<Image> filterImage(
            @RequestParam Optional<String> name
    ){
        return name.map(this.imageService::getImageByName)
                .orElse(this.imageService.getImages());
    }

}
