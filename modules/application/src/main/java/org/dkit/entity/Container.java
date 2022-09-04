package org.dkit.entity;

import lombok.*;
import org.dkit.entity.valueobject.Status;

@Getter
@RequiredArgsConstructor
public class Container {
    private final String id;
    @Setter
    private String name;
    @Setter
    private int order;
    private Status status;
    @Getter
    private Image image;
    @Getter
    private Volume volume;

    public boolean isRunning(){
        return status == Status.RUNNING;
    }

}
