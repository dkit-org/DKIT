package org.dkit.fxclient;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.dkit.fxclient.constants.Screen;
import org.dkit.fxclient.event.StageReadyEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class FXApplication extends Application {

    private GenericApplicationContext context;



    @Override
    public void init() throws Exception {
        // User dynamic beans registration to enhance startup time
        // (no reflection involved with dynamic bean registration)

        this.context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //this.context = new GenericApplicationContext();

        // general beans
        this.context.registerBean(Application.class, () -> this);
        this.context.registerBean(Parameters.class, this::getParameters);
        this.context.registerBean(HostServices.class, this::getHostServices);

        //this.context.registerBean(ApplicationEventPublisher.class, this.context);


        // mappers
        //this.context.registerBean(ImageDTOMapper.class, ImageDTOMapper::new);

        // controllers
        //this.context.registerBean(LoginController.class, () -> new LoginController(this.context));

    }

    @Override
    public void start(Stage stage)  {
        this.context.publishEvent(new StageReadyEvent(stage, Screen.LOGIN));
    }


    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }
}
