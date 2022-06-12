package org.dkit.fxclient.eventlistener;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.RequiredArgsConstructor;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.event.CloseScreenEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasicKeyboardEventListener implements EventHandler<KeyEvent> {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)){
            if (keyEvent.getCode().getCode() == KeyCode.ESCAPE.getCode()){
                this.eventPublisher.publishEvent(new CloseScreenEvent(Screen.ACTIONS));
            }
        }


    }
}
