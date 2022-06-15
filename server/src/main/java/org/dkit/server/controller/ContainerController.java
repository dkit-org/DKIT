package org.dkit.server.controller;

import lombok.RequiredArgsConstructor;
import org.dkit.api.ContainerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/container")
@RequiredArgsConstructor
public class ContainerController {
    private final ContainerService containerService;
}
