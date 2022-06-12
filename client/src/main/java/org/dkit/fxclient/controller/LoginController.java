package org.dkit.fxclient.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.events.NavigationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LoginController {
    private final ViewLoader viewLoader;
    private final ApplicationEventPublisher eventPublisher;
    public TextField username;
    public PasswordField password;
    public VBox loginScreen;
    private boolean notValidated = true;

    public LoginController(ViewLoader viewLoader, ApplicationEventPublisher eventPublisher){
        this.viewLoader = viewLoader;
        this.eventPublisher = eventPublisher;
    }

    public void loginHandler(ActionEvent actionEvent) {
//        if(isUserCredentialsValid()){
        if (true){
            this.eventPublisher.publishEvent(new NavigationEvent(Screen.DASHBOARD));
        }else if(this.notValidated) {
            var label = new Label("incorrect username or password");
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
