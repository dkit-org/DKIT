package org.dkit.fxclient.components;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class AKMenuBar implements CanRender {

    private final MenuBar menuBar;

    public AKMenuBar() {
        menuBar = new MenuBar();
        menuBar.getMenus().setAll(new Menu("File"));
    }


    @Override
    public Parent render() {
        return menuBar;
    }
}
