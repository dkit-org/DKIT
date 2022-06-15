package org.dkit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private List<Image> images;
    private List<Container> containers;
}
