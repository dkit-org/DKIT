package org.dkit.fxclient.eventlistener;

import org.dkit.fxclient.controller.ToolBarController;
import org.dkit.fxclient.event.SelectionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SelectionEventListener implements ApplicationListener<SelectionEvent> {

    private final ToolBarController toolBarController;

    public SelectionEventListener(ToolBarController toolBarController) {
        this.toolBarController = toolBarController;
    }

    @Override
    public void onApplicationEvent(SelectionEvent event) {
        switch (event.getSelectionType()){
            case SINGLE_CONTAINER: this.toolBarController.activateSingleContainerActions();  break;
            case MULTIPLE_CONTAINERS: this.toolBarController.activateMultipleContainersActions();  break;
            case SINGLE_IMAGE: this.toolBarController.activateSingleImageActions();  break;
            case MULTIPLE_IMAGES: this.toolBarController.activateMultipleImagesActions();  break;
            case REMOVE_SELECTION: this.toolBarController.removeSelection(); break;
        }
    }
}
