package org.dkit.fxclient.event;

import org.dkit.fxclient.constants.Screen;
import org.springframework.context.ApplicationEvent;

public class CloseScreenEvent extends ApplicationEvent {

    public Screen getScreen(){
        return (Screen) getSource();
    }

    public CloseScreenEvent(Screen screen) {
        super(screen);
    }
}
