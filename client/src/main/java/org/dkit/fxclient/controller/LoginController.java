package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.dkit.fxclient.common.ViewLoader;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.constants.View;
import org.dkit.fxclient.event.NavigationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginController {
    private final ApplicationEventPublisher eventPublisher;
    public TextField username;
    public PasswordField password;
    public VBox loginScreen;
    private boolean notValidated = true;


    public void loginHandler(ActionEvent actionEvent) {
//        if(isUserCredentialsValid()){
        if (true){
            this.eventPublisher.publishEvent(new NavigationEvent(Screen.DASHBOARD));
        }else if(this.notValidated) {
            var label = new Label("incorrect username or passrword");
            label.setTextFill(Color.RED);
            this.loginScreen.getChildren().add(label);
            this.notValidated = false;
        }
    }

    private boolean isUserCredentialsValid(){
        return this.username.getText().equals("admin")
                && this.password.getText().equals("password");
    }
}
