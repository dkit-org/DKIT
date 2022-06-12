package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class SideBarController implements Initializable {

    private final DashboardController mainController;
    private final ApplicationContext applicationContext;
    private final ViewLoader viewLoader;

    private Button selectedButton;

    public SideBarController(
            ApplicationContext applicationContext,
            DashboardController dashboardController, ViewLoader viewLoader){
        this.mainController = dashboardController;
        this.applicationContext = applicationContext;
        this.viewLoader = viewLoader;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void containerHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load("/widgets/ContainersWidget.fxml");
        this.mainController.setMainView(view);
    }

    public void imagesHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load("/widgets/ImagesWidget.fxml");
        this.mainController.setMainView(view);
    }

    public void settingsHandler(ActionEvent actionEvent) {
        this.activateButton((Button) actionEvent.getTarget());
        var view = this.viewLoader.<Node>load("/widgets/SettingsWidget.fxml");
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
