package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.events.NavigationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MenuBarController {


    private static final Logger LOG = LoggerFactory.getLogger(MenuBarController.class);
    private final ApplicationEventPublisher eventPublisher;

    public MenuBarController(ApplicationEventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }
    public void closeHandler(ActionEvent actionEvent) {
        System.out.println("close");
    }

    public void logoutHandler(ActionEvent actionEvent) {
        LOG.debug("publish navigation event to login screen");
        this.eventPublisher.publishEvent(new NavigationEvent(Screen.LOGIN));
    }
}
