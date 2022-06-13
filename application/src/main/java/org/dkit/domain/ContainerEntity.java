package org.dkit.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ContainerEntity extends Entity<String>{
    private String name;
}
