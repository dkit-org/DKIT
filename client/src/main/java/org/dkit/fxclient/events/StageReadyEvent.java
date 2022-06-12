package org.dkit.fxclient.events;

import javafx.stage.Stage;
import lombok.Getter;
import org.dkit.fxclient.constants.Screen;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {
    @Getter
    private final Screen initialScreen;
    public Stage getStage(){
        return (Stage) getSource();
    }

    public StageReadyEvent(Stage stage, Screen initialScreen) {
        super(stage);
        this.initialScreen = initialScreen;
    }
}
