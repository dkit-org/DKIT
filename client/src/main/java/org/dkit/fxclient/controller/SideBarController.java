package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import lombok.RequiredArgsConstructor;
import org.dkit.fxclient.core.ViewLoader;
import org.dkit.fxclient.constants.View;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class SideBarController implements Initializable {

    private final DashboardController mainController;
    private final ViewLoader viewLoader;

    private Button selectedButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void containerHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load(View.CONTAINERS.toString());
        this.mainController.setMainView(view);
    }

    public void imagesHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load(View.IMAGES.toString());
        this.mainController.setMainView(view);
    }

    public void settingsHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load(View.SETTINGS.toString());
        this.mainController.setMainView(view);
    }
    private void activateButton(Button btn){
        btn.getStyleClass().add("active");
        if(this.selectedButton != null) {
            this.selectedButton.getStyleClass().removeAll("active");
        }
        this.selectedButton = btn;
    }

}
