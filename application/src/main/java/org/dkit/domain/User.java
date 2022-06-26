package org.dkit.domain;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    private String id;

    @Getter
    @Setter
    private String userName;

    private List<Image> images;
    private List<Container> containers;
    private List<Application> applications;
}
