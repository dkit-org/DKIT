package org.dkit.fxclient.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Container {
    private final String id;
    private String name;
    private String imageId;
}
