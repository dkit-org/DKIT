package org.dkit.fxclient.components;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class AKSideBar implements CanRender {

    private final VBox container;

    public AKSideBar() {
        container = new VBox(
                new Label("some thing"),
                new Label("some thing else"));
        container.setStyle("-fx-background-color: grey");
    }

    @Override
    public Parent render() {
        return container;
    }
}
