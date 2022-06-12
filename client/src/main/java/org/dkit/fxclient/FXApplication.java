package org.dkit.fxclient;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.events.StageReadyEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class FXApplication extends Application {

    private GenericApplicationContext context;



    @Override
    public void init() throws Exception {
        this.context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        this.context.registerBean(Application.class, () -> this);
        this.context.registerBean(Parameters.class, this::getParameters);
        this.context.registerBean(HostServices.class, this::getHostServices);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.context.publishEvent(new StageReadyEvent(stage, Screen.LOGIN));
    }


    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }
}
