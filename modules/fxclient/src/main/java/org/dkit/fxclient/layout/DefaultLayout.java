package org.dkit.fxclient.layout;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.dkit.fxclient.components.AKMenuBar;
import org.dkit.fxclient.components.AKSideBar;
import org.dkit.fxclient.components.AKStatusBar;
import org.dkit.fxclient.components.AKToolBar;
import org.dkit.fxclient.core.CanRender;
import org.dkit.fxclient.core.Layout;

@Singleton
public class DefaultLayout implements CanRender, Layout {


    private final BorderPane borderPane;
    private final AKToolBar toolBar;
    private final AKMenuBar menuBar;
    private final AKSideBar sideBar;
    private final AKStatusBar statusBar;

    public DefaultLayout(
            AKToolBar toolBar,
            AKMenuBar menuBar,
            AKSideBar sideBar,
            AKStatusBar statusBar){
        this.borderPane = new BorderPane();
        this.toolBar = toolBar;
        this.menuBar = menuBar;
        this.sideBar = sideBar;
        this.statusBar = statusBar;
    }

    @Override
    public Parent render() {
        borderPane.setTop(new VBox(
                menuBar.render(),
                toolBar.render()
        ));

        borderPane.setLeft(sideBar.render());
        borderPane.setBottom(statusBar.render());

        return borderPane;
    }

    @Override
    public void setContent(CanRender canRender) {
        borderPane.setCenter(canRender.render());
    }
}
