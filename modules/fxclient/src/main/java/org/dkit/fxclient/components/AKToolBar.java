package org.dkit.fxclient.components;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class AKToolBar implements CanRender {
    private final ToolBar toolBar;

    public AKToolBar(){
        toolBar = new ToolBar();
        toolBar.getItems().setAll(new Button("some button"));
    }

    @Override
    public Parent render() {
        return toolBar;
    }
}
