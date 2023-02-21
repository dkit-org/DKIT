package org.dkit.fxclient;

import atlantafx.base.theme.NordDark;
import io.micronaut.context.BeanContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.dkit.fxclient.core.Layout;
import org.dkit.fxclient.layout.DefaultLayout;
import org.dkit.fxclient.pages.RequestPage;

import java.io.IOException;

public class ApiKitApplication extends Application {

    private BeanContext context;

    @Override
    public void init() throws Exception {
        context = BeanContext.run();
    }

    @Override
    public void start(Stage stage) throws IOException {

        Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());

        DefaultLayout layout = context.getBean(DefaultLayout.class);
        var requestPage = context.getBean(RequestPage.class);
        layout.setContent(requestPage);

        stage.setScene(new Scene(layout.render(), 800, 400));
        stage.show();
    }

}