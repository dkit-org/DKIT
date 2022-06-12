package org.dkit.fxclient.event;

import org.dkit.fxclient.constants.Screen;
import org.springframework.context.ApplicationEvent;

public class NavigationEvent extends ApplicationEvent {

    public NavigationEvent(Screen screen) {
        super(screen);
    }

    public Screen getScreen(){
        return (Screen) this.source;
    }

}
