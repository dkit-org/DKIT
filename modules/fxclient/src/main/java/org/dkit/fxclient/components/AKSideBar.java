package org.dkit.fxclient.components;

import jakarta.inject.Singleton;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.dkit.fxclient.core.CanRender;

import java.util.AbstractCollection;
import java.util.List;

@Singleton
public class AKSideBar implements CanRender
{
    @Override
    public Parent render()
    {
        var home       = new Button("home");
        var containers = new Button("containers");
        var images     = new Button("images");

        List.of(home, containers, images)
                .forEach(btn -> {
                    btn.setMaxWidth(Double.MAX_VALUE);
                });
        var dashboard =  new TitledPane("dashboard", new VBox(home));
        var docker = new TitledPane("docker", new VBox(containers, images));

        var accordion = new Accordion(dashboard, docker);
        accordion.setPrefWidth(200);
        return accordion;
    }
}
