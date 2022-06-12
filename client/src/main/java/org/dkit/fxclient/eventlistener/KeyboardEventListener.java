package org.dkit.fxclient.eventlistener;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.event.NavigationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class KeyboardEventListener extends BasicKeyboardEventListener implements EventHandler<KeyEvent> {


    private final ApplicationEventPublisher eventPublisher;

    public KeyboardEventListener(ApplicationEventPublisher eventPublisher) {
        super(eventPublisher);
        this.eventPublisher = eventPublisher;
    }


    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.isShiftDown()){
            if(keyEvent.getText().equals("p")) {
                this.eventPublisher.publishEvent(new NavigationEvent(Screen.ACTIONS));
            }
        }
    }
}
