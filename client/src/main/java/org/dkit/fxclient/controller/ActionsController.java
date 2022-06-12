package org.dkit.fxclient.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ActionsController implements Initializable {
    public VBox actionsScreen;
    public TextField input;
    public ListView resultsList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
