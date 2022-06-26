package org.dkit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dkit.domain.valueobject.ImageName;

import java.util.List;

@Data
@AllArgsConstructor
public class Image {
    private String id;
    private ImageName name;
    private List<Container> containers;
}
