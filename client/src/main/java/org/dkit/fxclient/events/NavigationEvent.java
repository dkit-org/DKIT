package org.dkit.fxclient.events;

import org.dkit.fxclient.constants.Screen;
import org.springframework.context.ApplicationEvent;

public class NavigationEvent extends ApplicationEvent {


    public Screen getScreen(){
        return (Screen) this.source;
    }

    public NavigationEvent(Screen screen) {
        super(screen);
    }

}
