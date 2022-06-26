package org.dkit.fxclient.eventlistener;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.RequiredArgsConstructor;
import org.dkit.fxclient.core.ViewLoader;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.event.CloseScreenEvent;
import org.dkit.fxclient.event.NavigationEvent;
import org.dkit.fxclient.event.StageReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NavigationEventListener {

    private final ViewLoader viewLoader;
    private final ApplicationContext applicationContext;
    private Map<Screen, Scene> screens = new HashMap<>();
    private Map<Screen, Stage> stages = new HashMap<>();
    private Stage mainStage;



    @EventListener(StageReadyEvent.class)
    public void handleStageReaderEvent(StageReadyEvent event) {
        var stage = event.getStage();
        this.mainStage = stage;
        var root = this.viewLoader.<Parent>load(Screen.LOGIN.toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        this.screens.put(Screen.LOGIN, scene);
        //scene.setOnKeyPressed(keyboardEventListener);
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }


    @EventListener(NavigationEvent.class)
    public void handleNavigationEvent(NavigationEvent event) {
        // check if the screen was cached
        if(screens.containsKey(event.getScreen())){
            this.mainStage.setScene(screens.get(event.getScreen()));
            return;
        }

        switch (event.getScreen()) {
            case LOGIN:
                navigateToLoginScreen();
                break;
            case DASHBOARD:
                navigateToDashboardScreen();
                break;
            case ACTIONS:
                navigateToActionStage();
                break;
        }
    }


    @EventListener(CloseScreenEvent.class)
    public void handleCloseScreenEvent(CloseScreenEvent event) {
        var stage = this.stages.get(event.getScreen().toString());
        if (stage != null) {
            stage.hide();
        }
    }


    private void navigateToDashboardScreen() {
        var root = this.viewLoader.<Parent>load(Screen.DASHBOARD.toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        this.screens.put(Screen.DASHBOARD, scene);
        scene.setOnKeyPressed(applicationContext.getBean(KeyboardEventListener.class));
        this.mainStage.setScene(scene);
    }

    private void navigateToLoginScreen() {
        var root = this.viewLoader.<Parent>load(Screen.LOGIN.toString());
        var scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(0, "/themes/base.css");
        this.mainStage.setScene(scene);
    }


    private void navigateToActionStage() {
        if(this.stages.containsKey(Screen.ACTIONS)){
            this.stages.get(Screen.ACTIONS).show();
            return;
        }

        var root = this.viewLoader.<Parent>load(Screen.ACTIONS.toString());
        var scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(0, "/themes/base.css");
        //scene.setOnKeyPressed(applicationContext.getBean(BasicKeyboardEventListener.class));
        var stage = new Stage();
        stage.setScene(scene);
        stage.initOwner(this.mainStage);
        stage.initStyle(StageStyle.DECORATED);
        this.stages.put(Screen.ACTIONS, stage);
        stage.show();
    }


}
