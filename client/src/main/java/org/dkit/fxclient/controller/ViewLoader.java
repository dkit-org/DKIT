package org.dkit.fxclient.controller;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViewLoader {

    private final ApplicationContext applicationContext;

    public ViewLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T load(final String path){
        try {
            var url = new ClassPathResource(path).getURL();
            var loader = new FXMLLoader(url);
            loader.setControllerFactory(this.applicationContext::getBean);
            return loader.<T>load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
