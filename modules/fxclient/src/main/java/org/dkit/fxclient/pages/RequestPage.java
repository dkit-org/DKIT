package org.dkit.fxclient.pages;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import org.dkit.fxclient.core.CanRender;

@Singleton
public class RequestPage  implements CanRender {



    @Override
    public Parent render() {
        return new Label("hello world");
    }
}
