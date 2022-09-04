package org.dkit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dkit.entity.valueobject.ImageName;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Image {
    private final String id;
    private ImageName name;
    private List<Container> containers;
}
