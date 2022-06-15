package org.dkit.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserEntity extends Entity<String> {
    private String name;
    private String password;
    private List<ImageEntity> images;
    private List<ContainerEntity> containers;
}
