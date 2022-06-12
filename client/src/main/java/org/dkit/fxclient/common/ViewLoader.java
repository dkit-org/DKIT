package org.dkit.fxclient.common;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ViewLoader {

    private final ApplicationContext applicationContext;
    public Map<String, Object> views = new HashMap<>();

    public ViewLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T load(final String path){
        // check if view loaded
        if(views.containsKey(path)) {
            return (T) this.views.get(path);
        }

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
