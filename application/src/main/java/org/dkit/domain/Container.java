package org.dkit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dkit.domain.valueobject.Status;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Container {
    private String id;
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
