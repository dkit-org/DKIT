package org.dkit.fxclient.controller;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class DashboardController {


    public BorderPane dashboardScreen;

    public void setMainView(Node node){
        this.dashboardScreen.setCenter(node);
    }
}
