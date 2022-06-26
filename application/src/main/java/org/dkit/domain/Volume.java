package org.dkit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dkit.domain.valueobject.VolumeType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Volume {
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    private VolumeType volumeType;
    private List<Container> containers;
}
