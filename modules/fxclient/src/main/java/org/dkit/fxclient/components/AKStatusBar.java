package org.dkit.fxclient.components;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class AKStatusBar implements CanRender {

    private final HBox container;

    public AKStatusBar(){
        this.container = new HBox();
    }

    @Override
    public Parent render() {
        container.getChildren().setAll(
          new Label("status bar")
        );
        container.setStyle("-fx-background-color: lightblue");
        return container;
    }
}
