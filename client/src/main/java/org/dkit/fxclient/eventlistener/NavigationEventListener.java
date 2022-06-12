package org.dkit.fxclient.eventlistener;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.controller.ViewLoader;
import org.dkit.fxclient.events.CloseScreenEvent;
import org.dkit.fxclient.events.NavigationEvent;
import org.dkit.fxclient.events.StageReadyEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NavigationEventListener  {

    private final KeyboardEventListener keyboardEventListener;
    private final BasicKeyboardEventListener basicKeyboardEventListener;
    private final String applicationTitle;
    private final ViewLoader viewLoader;
    private Stage mainStage;

    private Map<String, Stage>stages = new HashMap<>();

    public NavigationEventListener(
            KeyboardEventListener keyboardEventListener, BasicKeyboardEventListener basicKeyboardEventListener, @Value("${application.ui.title}") String applicationTitle,
            ViewLoader viewLoader){
        this.keyboardEventListener = keyboardEventListener;
        this.basicKeyboardEventListener = basicKeyboardEventListener;
        this.applicationTitle = applicationTitle;
        this.viewLoader = viewLoader;
    }


    @EventListener
    public void handleNavigationEvent(NavigationEvent event) {
        switch (event.getScreen()){
            case LOGIN: navigateToLoginScreen(); break;
            case DASHBOARD: navigateToDashboardScreen(); break;
            case ACTIONS: navigateToActionsScreen(); break;
        }
    }


    private void navigateToActionsScreen() {
        var stage = new Stage();
        this.stages.put(Screen.ACTIONS.toString(), stage);
        stage.setTitle(this.applicationTitle);
        stage.initOwner(this.mainStage);
        var root = this.viewLoader.<Parent>load(Screen.ACTIONS.toString());
        var scene = new Scene(root);
        scene.getStylesheets().add(0, "/themes/base.css");
        scene.setOnKeyPressed(this.basicKeyboardEventListener);
        stage.setScene(scene);
        stage.show();
    }

    private void navigateToDashboardScreen() {
        var root = this.viewLoader.<Parent>load(Screen.DASHBOARD.toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        scene.setOnKeyPressed(keyboardEventListener);
        this.mainStage.setScene(scene);
    }

    private void navigateToLoginScreen() {
        var root = this.viewLoader.<Parent>load(Screen.LOGIN.toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        this.mainStage.setScene(scene);
    }

    @EventListener
    public void handleStageReadyEvent(StageReadyEvent event){
        this.mainStage = event.getStage();
        var root = this.viewLoader.<Parent>load(event.getInitialScreen().toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        this.mainStage.setScene(scene);
        this.mainStage.setTitle(this.applicationTitle);
        this.mainStage.show();
    }


    @EventListener
    public void handleCloseScreenEvent(CloseScreenEvent event){
        var stage = this.stages.get(event.getScreen().toString());
        if(stage != null){
            stage.close();
        }
    }

}
